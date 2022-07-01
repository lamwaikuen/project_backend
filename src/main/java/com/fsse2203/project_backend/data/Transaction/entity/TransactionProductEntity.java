package com.fsse2203.project_backend.data.Transaction.entity;

import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;
import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "transaction_Product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transaction_Product")
    private Integer tpid;
    @ManyToOne
    @JoinColumn(name = "tid",nullable = false)
    private TransactionEntity transaction;
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name="product_imageUrl")
    private String imageUrl;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name="product_stock",nullable = false)
    private Integer stock;
    @Column(name="product_description")
    private String description;
    @Column(name="quantity",nullable = false)
    private Integer quantity;
    @Column(name="subtotal",nullable = false)
    private Double subtotal;

    public TransactionProductEntity(){
    }

    public TransactionProductEntity(CartItemEntity cartItemEntity,TransactionEntity transaction) {
        this.transaction=transaction;
        this.pid = cartItemEntity.getProduct().getPid();
        this.name = cartItemEntity.getProduct().getName();
        this.imageUrl = cartItemEntity.getProduct().getImageUrl();
        this.price = cartItemEntity.getProduct().getPrice();
        this.stock = cartItemEntity.getProduct().getStock();
        this.description = cartItemEntity.getProduct().getDescription();
        this.quantity =cartItemEntity.getQuantity();
        setSubtotal(cartItemEntity);
    }


    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTid() {
        return transaction;
    }

    public void setTransaction(TransactionEntity tid) {
        this.transaction = tid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(CartItemEntity entity) {
        this.subtotal = entity.getProduct().getPrice()*entity.getQuantity();
    }
}
