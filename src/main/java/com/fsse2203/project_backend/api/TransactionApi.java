package com.fsse2203.project_backend.api;

import com.fsse2203.project_backend.config.EnvConfig;
import com.fsse2203.project_backend.data.Transaction.dto.response.TransactionDetailResponseDto;
import com.fsse2203.project_backend.exception.*;
import com.fsse2203.project_backend.service.TransactionService;
import com.fsse2203.project_backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {EnvConfig.devBaseUrl,EnvConfig.proBaseUrl},maxAge = 3600)
@RestController
public class TransactionApi {
    public final TransactionService transactionService;

    @Autowired
    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction/prepare")
    public TransactionDetailResponseDto CreateNewTransaction(Authentication authentication) throws UserNotFoundException, TransactionNotFoundException, CartEmptyException, CartItemNotFoundException {
        return new TransactionDetailResponseDto(transactionService.createTransaction(SecurityUtil.getFireBaseUid(authentication)));
    }

    @GetMapping("/transaction/{tid}")
    public TransactionDetailResponseDto getTransactionByTid(@PathVariable Integer tid,Authentication authentication)throws TransactionNotFoundException{
        return new TransactionDetailResponseDto(transactionService.getTransactionByTid(tid,SecurityUtil.getFireBaseUid(authentication)));
    }

    @PatchMapping("/transaction/{tid}/pay")
    public TransactionDetailResponseDto transactionPay(@PathVariable Integer tid,Authentication authentication)throws TransactionNotFoundException, StockNotEnoughException,ProductNotFoundException{
        return  new TransactionDetailResponseDto(transactionService.transactionPay(tid,SecurityUtil.getFireBaseUid(authentication)));
    }

    @PatchMapping("/transaction/{tid}/finish")
    public TransactionDetailResponseDto transactionFinish(@PathVariable Integer tid,Authentication authentication)throws TransactionNotFoundException{
        return new TransactionDetailResponseDto(transactionService.transactionFinish(tid,SecurityUtil.getFireBaseUid(authentication)));
    }

}





