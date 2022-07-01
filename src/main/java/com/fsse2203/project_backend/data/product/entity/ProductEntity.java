package com.fsse2203.project_backend.data.product.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.product.CreateProductData;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public ProductEntity() {
    }

    public ProductEntity(CreateProductData data) {
        this.name = data.getName();
        this.imageUrl=data.getImageUrl();
        this.price = data.getPrice();
        this.stock = data.getStock();
        this.description = data.getDescription();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
