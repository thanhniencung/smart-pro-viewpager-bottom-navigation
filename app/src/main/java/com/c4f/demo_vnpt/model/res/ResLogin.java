package com.c4f.demo_vnpt.model.res;

import com.google.gson.annotations.SerializedName;

public class ResLogin {
    @SerializedName("token")
    private String token;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("displayName")
    private String displayName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
