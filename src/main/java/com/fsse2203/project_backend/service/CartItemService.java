package com.fsse2203.project_backend.service;

import com.fsse2203.project_backend.data.cart_item.CartItemDetailData;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.exception.CartItemNotFoundException;
import com.fsse2203.project_backend.exception.ProductNotFoundException;
import com.fsse2203.project_backend.exception.QuantityInvalidExcepution;
import com.fsse2203.project_backend.exception.UserNotFoundInCartException;

import java.util.List;

public interface CartItemService {
 boolean addItemtoCart(String FirebaseUid,Integer pid,Integer quantity)throws UserNotFoundInCartException,QuantityInvalidExcepution,ProductNotFoundException;
 List<CartItemDetailData> getUserCart(String FireBaseUid)throws UserNotFoundInCartException;
 CartItemDetailData UpdateCartQuantity(String firebaseUid, Integer pid, Integer quantity)throws CartItemNotFoundException,QuantityInvalidExcepution;
 boolean removeCartItem(String FireBaseUid,Integer pid)throws CartItemNotFoundException;
 List<CartItemEntity> getAllCartItemEntitiesByUserEntity(UserEntity userentity);
 void emptyCartItem(UserEntity user);
}
