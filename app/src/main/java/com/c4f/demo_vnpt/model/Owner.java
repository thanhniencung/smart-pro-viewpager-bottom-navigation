package com.c4f.demo_vnpt.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
