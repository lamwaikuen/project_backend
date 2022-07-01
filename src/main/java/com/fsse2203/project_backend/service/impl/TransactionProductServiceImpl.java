package com.fsse2203.project_backend.service.impl;

import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionEntity;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.exception.CartItemNotFoundException;
import com.fsse2203.project_backend.exception.TransactionNotFoundException;
import com.fsse2203.project_backend.exception.UserNotFoundInCartException;
import com.fsse2203.project_backend.repository.CartItemRepository;
import com.fsse2203.project_backend.repository.TransactionProductRepository;
import com.fsse2203.project_backend.repository.TransactionRepository;
import com.fsse2203.project_backend.service.CartItemService;
import com.fsse2203.project_backend.service.TransactionProductService;
import com.fsse2203.project_backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductRepository transactionProductRepository;
    Logger logger = LoggerFactory.getLogger(TransactionProductServiceImpl.class);

    @Autowired
    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }


    public TransactionProductEntity createTransactionProduct(CartItemEntity cartItemEntity,TransactionEntity transactionEntity) throws CartItemNotFoundException, TransactionNotFoundException {
        if(cartItemEntity==null){
            logger.warn("createTransactionProduct:cartItemEntity is null");
            throw new CartItemNotFoundException();
        }
     if(transactionEntity ==null){
         logger.warn("createTransactionProduct:transactionEntity is null");
         throw new TransactionNotFoundException();
     }
     return transactionProductRepository.save(new TransactionProductEntity(cartItemEntity,transactionEntity));
    }

}
