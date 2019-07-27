package com.c4f.demo_vnpt.network;

import com.c4f.demo_vnpt.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {
    //https://api.github.com/users/thanhniencung/repos
    // https://api.github.com/users/thanhniencung/repos
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
