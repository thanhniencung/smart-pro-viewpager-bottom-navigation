package com.c4f.demo_vnpt.network;

import com.c4f.demo_vnpt.model.BaseResponse;
import com.c4f.demo_vnpt.model.Repo;
import com.c4f.demo_vnpt.model.res.ResLogin;
import com.c4f.demo_vnpt.model.res.ResProduct;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GithubApi {
    //https://api.github.com/users/thanhniencung/repos
    // https://api.github.com/users/thanhniencung/repos
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @POST("http://10.0.2.2:8000/user/sign-in")
    Call<BaseResponse<ResLogin>> signIn(@Body  RequestBody body);

    @GET("http://10.0.2.2:8000/product/list")
    Call<BaseResponse<List<ResProduct>>> getProductList();
}
