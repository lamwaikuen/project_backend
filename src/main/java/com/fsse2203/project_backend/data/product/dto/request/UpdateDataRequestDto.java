package com.fsse2203.project_backend.data.product.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDataRequestDto {
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_Url")
    private String imageUrl;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("description")
    private String description;

    public Integer getPid(){
        return  pid;
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
        this.imageUrl= imageUrl;
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

