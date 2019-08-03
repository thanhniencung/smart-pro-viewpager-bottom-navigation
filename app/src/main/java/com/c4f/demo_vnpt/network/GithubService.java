package com.c4f.demo_vnpt.network;

import com.c4f.demo_vnpt.BuildConfig;
import com.c4f.demo_vnpt.VNPTApplication;
import com.c4f.demo_vnpt.contant.AppConstant;
import com.c4f.demo_vnpt.helper.SharedPreferenceHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {

    static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HeaderInterceptor())
            .build();


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static GithubApi get() {
        return retrofit.create(GithubApi.class);
    }

    public static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain)
                throws IOException {
            Request request = chain.request();

            String token = SharedPreferenceHelper.getSharedPreferenceString(
                    VNPTApplication.getApp(), AppConstant.Key.TOKEN, null);

            Request.Builder builder = request.newBuilder();
            if (token != null) {
                String valueAuthorization = String.format("Bearer %s", token);
                builder.addHeader("Authorization", valueAuthorization);
            }

            Response response = chain.proceed(builder.build());
            return response;
        }
    }
}
