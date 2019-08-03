package com.c4f.demo_vnpt.model.req;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ReqLogin {
    @SerializedName("phone")
    private String phone;

    @SerializedName("password")
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static RequestBody createRequestBody() {
        try {
            ReqLogin data = new ReqLogin();
            data.setPhone("0973901990");
            data.setPassword("123456789");

            return RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    new Gson().toJson(data));
        } catch (Exception exp) {}

        return null;
    }
}
