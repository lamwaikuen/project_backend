package com.fsse2203.project_backend.service;

import com.fsse2203.project_backend.data.Transaction.TransactionDetailData;
import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionEntity;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.user.entity.UserEntity;
import com.fsse2203.project_backend.exception.*;

import java.util.List;

public interface TransactionProductService {
    TransactionProductEntity createTransactionProduct(CartItemEntity cartItemEntity,TransactionEntity transactionEntity) throws CartItemNotFoundException, TransactionNotFoundException;
}
