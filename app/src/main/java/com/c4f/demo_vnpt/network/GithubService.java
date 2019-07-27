package com.c4f.demo_vnpt.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static GithubApi get() {
        return retrofit.create(GithubApi.class);
    }
}
