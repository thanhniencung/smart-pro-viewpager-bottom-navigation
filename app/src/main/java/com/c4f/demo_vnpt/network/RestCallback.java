package com.c4f.demo_vnpt.network;

import com.c4f.demo_vnpt.network.model.RestError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RestCallback<T> implements Callback<T>{

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        }

        RestError restError = new RestError();
        restError.setStatusCode(response.code());

        onFailure(restError);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestError restError = new RestError();
        restError.setStatusCode(-1);
        restError.setMessage(t.getMessage());

        onFailure(restError);
    }

    public abstract void onSuccess(T data);
    public abstract void onFailure(RestError restError);
}
