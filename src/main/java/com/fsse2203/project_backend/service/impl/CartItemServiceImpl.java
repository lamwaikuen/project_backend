package com.fsse2203.project_backend.service.impl;

import com.fsse2203.project_backend.data.cart_item.CartItemDetailData;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.exception.CartItemNotFoundException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.QuantityInvalidExcepution;
import com.fsse2203.project_backend.exception.UserNotFoundInCartException;
import com.fsse2203.project_backend.repository.CartItemRepository;
import com.fsse2203.project_backend.repository.ProductRepository;
import com.fsse2203.project_backend.repository.UserRepository;
import com.fsse2203.project_backend.service.CartItemService;
import com.fsse2203.project_backend.service.ProductService;
import com.fsse2203.project_backend.service.UserService;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartitemRepository;
    private final UserService userService;
    private final ProductService productService;
    Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartitemRepository, UserService userService, ProductService productService) {
        this.cartitemRepository = cartitemRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public boolean addItemtoCart(String firebaseUid, Integer pid, Integer quantity) throws UserNotFoundInCartException ,QuantityInvalidExcepution, ProductNotFoundException {
        if (quantity <=0 ) {
            logger.warn("addCartItem: Invaid Quantity");
            throw new QuantityInvalidExcepution();
        }
        UserEntity userEntity = userService.getUserEntityByfireBaseUid(firebaseUid);
        if(userEntity==null){
            logger.warn("addCartItem:User Not Found");
            throw new UserNotFoundInCartException();
        }
        ProductEntity searchEntity = productService.searchPid(pid);
        if(searchEntity==null){
            logger.warn("addCartItem:Product Not Found");
            throw new ProductNotFoundException();
        }

        CartItemEntity cartItemEntity=cartitemRepository.findCartItemEntitiesByProductAndUser(searchEntity,userEntity);

        if(cartItemEntity==null){
            if(quantity>searchEntity.getStock()){
                logger.warn("addCartItem: Not Enough Stock");
                throw new QuantityInvalidExcepution();
            }
            cartItemEntity=cartitemRepository.save(new CartItemEntity(userEntity,searchEntity,quantity));
        }else{
            if(cartItemEntity.getQuantity() + quantity > searchEntity.getStock()){
                logger.warn("addCartItem: Not Enough Stock");
                throw new QuantityInvalidExcepution();
            }cartItemEntity.setQuantity(quantity+cartItemEntity.getQuantity());
            cartItemEntity=cartitemRepository.save(cartItemEntity);
        }
        return true;
    }


    @Override
    public List<CartItemDetailData> getUserCart(String firebaseUid)throws UserNotFoundInCartException{
        UserEntity userEntity = userService.getUserEntityByfireBaseUid(firebaseUid);
        if(userEntity==null){
            logger.warn("addCartItem:User Not Found");
            throw new UserNotFoundInCartException();
        }
        List<CartItemDetailData> cartItemDetailDataList=new ArrayList<>();
        for(CartItemEntity entity:cartitemRepository.findCartItemEntityByUser(userEntity)){
            cartItemDetailDataList.add(new CartItemDetailData(entity));
        }
        return cartItemDetailDataList;
    }

    @Override
    public CartItemDetailData UpdateCartQuantity(String firebaseUid, Integer pid, Integer quantity) throws CartItemNotFoundException,QuantityInvalidExcepution{
        CartItemEntity cartItemEntity=cartitemRepository.findCartItemEntityByUser_FirebaseUidAndProduct_Pid(firebaseUid,pid);
            if(cartItemEntity==null){
                logger.warn("updateCartItem: CartItem Not Found");
                throw new CartItemNotFoundException();
            }
            if(quantity<=0||quantity>=cartItemEntity.getProduct().getStock()){
            logger.warn("addCartItem: Invaid Quantity");
            throw new QuantityInvalidExcepution();
            }
            cartItemEntity.setQuantity(quantity);

            return new CartItemDetailData(cartitemRepository.save(cartItemEntity));
        }


    @Override
    public boolean removeCartItem(String firebaseUid,Integer pid) throws CartItemNotFoundException {
        CartItemEntity cartItemEntity=cartitemRepository.findCartItemEntityByUser_FirebaseUidAndProduct_Pid(firebaseUid,pid);
        if(cartItemEntity==null){
            logger.warn("updateCartItem: CartItem Not Found");
            throw new CartItemNotFoundException();
        }
        cartitemRepository.delete(cartItemEntity);
        return true;
    }

    @Override
    public List<CartItemEntity> getAllCartItemEntitiesByUserEntity(UserEntity userentity){
        return cartitemRepository.findCartItemEntityByUser(userentity);
         }

         @Override
         public void emptyCartItem(UserEntity user){
        List<CartItemEntity>cartItemEntityList=cartitemRepository.findCartItemEntityByUser(user);
        cartitemRepository.deleteAll(cartItemEntityList);
         }


}






