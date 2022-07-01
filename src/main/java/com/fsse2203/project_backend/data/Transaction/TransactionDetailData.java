package com.fsse2203.project_backend.data.Transaction;

import com.fsse2203.project_backend.data.Transaction.entity.TransactionEntity;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.user.UserDetailData;
import com.fsse2203.project_backend.data.user.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDetailData {
    private Integer tid;
    private UserDetailData user;
    private LocalDateTime dateTime;
    private Status status;
    private Double totalprice;
    private List<TransactionProductDetailData> transactionProduct=new ArrayList<>();


    public TransactionDetailData(TransactionEntity entity){
        this.tid=entity.getTid();
        this.user=new UserDetailData(entity.getUser());
        this.dateTime=entity.getDateTime();
        this.status=entity.getStatus();
        this.totalprice=entity.getTotalprice();
        setTransactionProduct(entity.getTransactionProduct());
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserDetailData getUser() {
        return user;
    }

    public void setUid(UserEntity user) {
        this.user = new UserDetailData(user);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public List<TransactionProductDetailData> getTransactionProduct() {
        return transactionProduct;
    }

    public void setTransactionProduct(List<TransactionProductEntity> transactionProductEntities) {
        for(TransactionProductEntity transactionProductEntity:transactionProductEntities){
        this.transactionProduct.add(new TransactionProductDetailData(transactionProductEntity));
        }
    }
}
