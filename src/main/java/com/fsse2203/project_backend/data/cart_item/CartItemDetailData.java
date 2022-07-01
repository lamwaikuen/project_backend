package com.fsse2203.project_backend.data.cart_item;

import com.fsse2203.project_backend.data.cart_item.entity.CartItemEntity;
import com.fsse2203.project_backend.data.product.ProductDetailData;
import com.fsse2203.project_backend.data.product.entity.ProductEntity;

public class CartItemDetailData {
    private ProductDetailData product;
    private Integer quantity;

    public CartItemDetailData(CartItemEntity entity) {
        setPid(entity.getProduct());
        this.quantity=entity.getQuantity();
    }


    public ProductDetailData getProduct() {
        return product;
    }

    public void setPid(ProductEntity product) {
        this.product = new ProductDetailData(product);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
