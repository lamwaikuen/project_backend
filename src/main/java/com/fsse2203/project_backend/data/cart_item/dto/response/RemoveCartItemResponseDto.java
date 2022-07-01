package com.fsse2203.project_backend.data.cart_item.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoveCartItemResponseDto {
    @JsonProperty("result")
    private String result;

    public RemoveCartItemResponseDto(boolean data) {
        setResult(data);
    }

    public String getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        if (!result) {
            this.result = "FAIL";
        }
        if (result) {
            this.result = "SUCCESS";
        }
    }
}

