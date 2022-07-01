package com.fsse2203.project_backend.data.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.product.ProductDetailData;

public class GetProductResponseDto {
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_Url")
    private String imageUrl;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("has_Stock")
    private Boolean stock;

    public GetProductResponseDto(ProductDetailData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        setStock(data.getStock());
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

    public Boolean getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        if(stock<=0){
            this.stock=false;
        }
        if(stock>0){
            this.stock=true;
        }
    }
}
