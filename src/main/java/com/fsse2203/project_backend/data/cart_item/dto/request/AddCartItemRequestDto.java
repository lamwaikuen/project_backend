package com.fsse2203.project_backend.data.cart_item.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCartItemRequestDto {
    @JsonProperty("cid")
    private Integer cid;
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("uid")
    private Integer uid;
    @JsonProperty("quantity")
    private Integer quantity;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


