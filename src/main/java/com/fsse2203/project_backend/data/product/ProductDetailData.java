package com.fsse2203.project_backend.data.product;

import com.fsse2203.project_backend.data.Transaction.TransactionDetailData;
import com.fsse2203.project_backend.data.Transaction.entity.TransactionProductEntity;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;

public class ProductDetailData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private Double price;
    private Integer stock;
    private String description;

    public ProductDetailData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.name = entity.getName();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
        this.description = entity.getDescription();
    }

    public ProductDetailData(TransactionProductEntity entity) {
        this.pid = entity.getPid();
        this.name = entity.getName();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
        this.description = entity.getDescription();
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
}
