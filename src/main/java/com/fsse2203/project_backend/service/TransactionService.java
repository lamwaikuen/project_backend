package com.fsse2203.project_backend.service;

import com.fsse2203.project_backend.data.Transaction.TransactionDetailData;
import com.fsse2203.project_backend.exception.*;

public interface TransactionService {
    TransactionDetailData createTransaction(String firebaseUid) throws UserNotFoundException, CartEmptyException, TransactionNotFoundException, CartItemNotFoundException;
    TransactionDetailData getTransactionByTid(Integer tid,String firebaseUid)throws TransactionNotFoundException;
    TransactionDetailData transactionPay(Integer tid,String firebaseUid)throws TransactionNotFoundException, StockNotEnoughException,ProductNotFoundException;
    TransactionDetailData transactionFinish(Integer tid,String firebaseUid)throws TransactionNotFoundException;
}
