package com.fsse2203.project_backend.repository;

import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItemEntity,Integer> {
    CartItemEntity findCartItemEntitiesByProductAndUser(ProductEntity product, UserEntity user);
    List<CartItemEntity> findCartItemEntityByUser(@Param("user")UserEntity user);
    CartItemEntity findCartItemEntityByUser_FirebaseUidAndProduct_Pid(String firebaseUid,Integer pid);
}
