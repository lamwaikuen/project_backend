package com.fsse2203.project_backend.data.cart_item;

import com.fsse2203.project_backend.data.cart_item.dto.request.AddCartItemRequestDto;

public class CreateCartItemData {
    private String firebaseUid;
    private Integer pid;
    private Integer quantity;

    public CreateCartItemData(AddCartItemRequestDto dto){
        this.pid=dto.getPid();
        this.quantity=dto.getQuantity();
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

