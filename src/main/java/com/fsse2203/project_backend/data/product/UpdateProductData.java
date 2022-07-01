package com.fsse2203.project_backend.data.product;

import com.fsse2203.project_backend.data.product.dto.request.UpdateDataRequestDto;

public class UpdateProductData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private Double price;
    private Integer stock;
    private String description;

    public UpdateProductData(UpdateDataRequestDto dto) {
        this.pid = dto.getPid();
        this.name = dto.getName();
        this.imageUrl = dto.getImageUrl();
        this.price = dto.getPrice();
        this.stock = dto.getStock();
        this.description = dto.getDescription();
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

