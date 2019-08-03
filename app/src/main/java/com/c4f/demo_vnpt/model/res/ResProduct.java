package com.c4f.demo_vnpt.model.res;

import com.google.gson.annotations.SerializedName;

public class ResProduct {
    @SerializedName("UserId")
    private String UserId;

    @SerializedName("productId")
    private String productId;

    @SerializedName("productName")
    private String productName;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
