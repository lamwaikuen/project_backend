package com.fsse2203.project_backend.data.Transaction;

import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.product.ProductDetailData;

import javax.persistence.Column;
import java.util.List;

public class TransactionProductDetailData {
    private Integer tpid;
    private Integer pid;
    private String name;
    private String imageUrl;
    private Double price;
    private Integer stock;
    private String description;
    private Integer quantity;
    private Double subtotal;

    public TransactionProductDetailData(TransactionProductEntity entity){
        this.tpid=entity.getTpid();
        this.pid=entity.getPid();
        this.name=entity.getName();
        this.imageUrl=entity.getImageUrl();
        this.price=entity.getPrice();
        this.stock=entity.getStock();
        this.description=entity.getDescription();
        this.quantity=entity.getQuantity();
        this.subtotal=entity.getSubtotal();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
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

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}

