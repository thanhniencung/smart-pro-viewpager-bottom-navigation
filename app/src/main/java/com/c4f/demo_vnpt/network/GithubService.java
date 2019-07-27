package com.c4f.demo_vnpt.network;

import com.c4f.demo_vnpt.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GithubService {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static GithubApi get() {
        return retrofit.create(GithubApi.class);
    }
}
