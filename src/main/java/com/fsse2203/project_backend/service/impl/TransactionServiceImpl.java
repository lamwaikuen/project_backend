package com.fsse2203.project_backend.service.impl;

import com.fsse2203.project_backend.data.Transaction.Status;
import com.fsse2203.project_backend.data.Transaction.TransactionDetailData;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionEntity;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.exception.*;
import com.fsse2203.project_backend.repository.CartItemRepository;
import com.fsse2203.project_backend.repository.ProductRepository;
import com.fsse2203.project_backend.repository.TransactionProductRepository;
import com.fsse2203.project_backend.repository.TransactionRepository;
import com.fsse2203.project_backend.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CartItemService cartItemService;
    private final UserService userService;
    private final TransactionProductService transactionProductService;
    private  final ProductService productService;
    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);


    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CartItemService cartItemService , UserService userService, TransactionProductService transactionProductService,ProductServiceImpl productService) {
        this.transactionRepository = transactionRepository;
        this.cartItemService=cartItemService;
        this.transactionProductService=transactionProductService;
        this.userService=userService;
        this.productService=productService;
    }

    @Override
    public TransactionDetailData createTransaction(String firebaseUid) throws UserNotFoundException, CartEmptyException, TransactionNotFoundException,CartItemNotFoundException {
        UserEntity userEntity = userService.getUserEntityByfireBaseUid(firebaseUid);
        List<CartItemEntity> cartItemEntities = cartItemService.getAllCartItemEntitiesByUserEntity(userEntity);
        if (userEntity == null) {
            logger.warn("createTransaction:User Not Found");
            throw new UserNotFoundException();
        }

        if (cartItemEntities == null || cartItemEntities.size() == 0) {
            logger.warn("createTransaction:Cart is Empty");
            throw new CartEmptyException();
        }
        TransactionEntity transactionEntity = transactionRepository.save(new TransactionEntity(userEntity, cartItemEntities));

        List<TransactionProductEntity>transactionProductEntities=new ArrayList<>();
        for(CartItemEntity cartItemEntity: cartItemEntities){
            transactionProductEntities.add(transactionProductService.createTransactionProduct(cartItemEntity,transactionEntity));
    }
        transactionEntity.setTransactionProduct(transactionProductEntities);
        return new TransactionDetailData(transactionEntity);
    }

    @Override
    public TransactionDetailData getTransactionByTid(Integer tid,String firebaseUid)throws TransactionNotFoundException{
        TransactionEntity transactionEntity=transactionRepository.findByTidAndUser_FirebaseUid(tid,firebaseUid);
        if(transactionEntity==null){
            logger.warn("getTransactionByTid:Transaction Not Found");
            throw new TransactionNotFoundException();
        }
        return new TransactionDetailData(transactionEntity);
    }

    @Override
    public TransactionDetailData transactionPay(Integer tid,String firebaseUid)throws TransactionNotFoundException,StockNotEnoughException,ProductNotFoundException{
        TransactionEntity transactionEntity=transactionRepository.findByTidAndUser_FirebaseUid(tid,firebaseUid);
        if(transactionEntity==null){
            logger.warn("getTransactionByTid:Transaction Not Found");
            throw new TransactionNotFoundException();
        }
        for(TransactionProductEntity entity:transactionEntity.getTransactionProduct()){
            productService.deduceProductStockByPid(entity.getPid(),entity.getQuantity());
        }
        transactionEntity.setStatus(Status.PROCESSING);
        return  new TransactionDetailData(transactionRepository.save(transactionEntity));
    }

    @Override
    @Transactional
    public TransactionDetailData transactionFinish(Integer tid,String firebaseUid)throws TransactionNotFoundException{
        TransactionEntity transactionEntity=transactionRepository.findByTidAndUser_FirebaseUid(tid,firebaseUid);
        if(transactionEntity==null){
            logger.warn("getTransactionByTid:Transaction Not Found");
            throw new TransactionNotFoundException();
        }
        cartItemService.emptyCartItem(transactionEntity.getUser());
        transactionEntity.setStatus(Status.SUCCESS);
        return  new TransactionDetailData(transactionRepository.save(transactionEntity));
    }


}
