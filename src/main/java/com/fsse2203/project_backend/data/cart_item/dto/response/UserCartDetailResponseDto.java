package com.fsse2203.project_backend.data.cart_item.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.cart_item.CartItemDetailData;

public class UserCartDetailResponseDto {
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_Url")
    private String imageUrl;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("cart_Quantity")
    private Integer quantity;
    @JsonProperty("Stock")
    private Integer stock;

    public UserCartDetailResponseDto(CartItemDetailData data) {
        this.pid = data.getProduct().getPid();
        this.name =data.getProduct().getName();
        this.imageUrl = data.getProduct().getImageUrl();
        this.price = data.getProduct().getPrice();
        this.quantity = data.getQuantity();
        this.stock = data.getProduct().getStock();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
