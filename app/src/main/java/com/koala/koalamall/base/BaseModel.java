package com.koala.koalamall.base;


import android.support.annotation.NonNull;

import com.koala.koalamall.interfaces.ServerInterface;
import com.koala.koalamall.utils.GsonUtil;
import com.koala.koalamall.utils.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/9/20.
 */

public class BaseModel {
    private Retrofit stringRetrofit;//返回字符串
    private Retrofit gsonRetrofit;//返回对象

    public BaseModel() {
        stringRetrofit = new Retrofit.Builder().baseUrl(ServerInterface.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(getClient())
                .build();

        gsonRetrofit = new Retrofit.Builder().baseUrl(ServerInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    protected Retrofit getStringRetrofit() {
        return stringRetrofit;
    }

    protected Retrofit getGsonRetrofit() {
        return gsonRetrofit;
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().build();
                        LogUtils.e("post=> " + request.url() + GsonUtil.GsonString(request.body()));
                        return chain.proceed(request);
                    }
                })
                .build();
    }
}
