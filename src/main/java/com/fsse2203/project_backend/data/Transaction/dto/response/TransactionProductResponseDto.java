package com.fsse2203.project_backend.data.Transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2203.project_backend.data.Transaction.TransactionProductDetailData;
import com.fsse2203.project_backend.data.cart_item.CartItemDetailData;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.dto.response.ProductDetailResponseDto;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductDetailResponseDto product=new ProductDetailResponseDto();
    private Integer quantity;
    private Double subtotal;


    public TransactionProductResponseDto(TransactionProductDetailData data) {
        this.tpid=data.getTpid();
        setProduct(data);
        this.quantity=data.getQuantity();
        this.subtotal=data.getSubtotal();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductDetailResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductDetailResponseDto product) {
        this.product = product;
    }

    public void setProduct(TransactionProductDetailData data){
        this.product.setPid(data.getPid());
        this.product.setName(data.getName());
        this.product.setImageUrl(data.getImageUrl());
        this.product.setDescription(data.getDescription());
        this.product.setStock(data.getStock());
        this.product.setPrice(data.getPrice());
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


