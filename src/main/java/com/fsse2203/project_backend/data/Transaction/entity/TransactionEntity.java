package com.fsse2203.project_backend.data.Transaction.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.Transaction.Status;
import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;
import com.fsse2203.project_backend.data.Transaction.dto.response.TransactionProductResponseDto;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.dto.response.ProductDetailResponseDto;
import com.fsse2203.project_backend.data.user.entity.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tid;
    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private UserEntity user;
    @Column(name = "Date_Time", nullable = false)
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "total_price", nullable = false)
    private Double totalprice;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionProductEntity> transactionProduct;


    public TransactionEntity() {
    }

    public TransactionEntity(UserEntity user, List<CartItemEntity> cartItemEntities) {
        this.user = user;
        this.dateTime = LocalDateTime.now();
        this.status = Status.PREPARE;
         setTotalprice(cartItemEntities);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public void setTotalprice(List<CartItemEntity> cartItemEntities) {
        this.totalprice = 0.0;
        for (CartItemEntity entity : cartItemEntities) {
            totalprice += entity.getProduct().getPrice() * entity.getQuantity();
        }
    }

    public List<TransactionProductEntity> getTransactionProduct() {
        return transactionProduct;
    }

    public void setTransactionProduct(List<TransactionProductEntity> transactionProduct) {
        this.transactionProduct = transactionProduct;
    }
}
