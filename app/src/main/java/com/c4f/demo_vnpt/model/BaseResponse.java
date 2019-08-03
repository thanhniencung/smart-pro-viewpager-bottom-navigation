package com.c4f.demo_vnpt.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

//BaseResponse<ResLogin>
public class BaseResponse<T> {
    @SerializedName("data")
    private T data;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
