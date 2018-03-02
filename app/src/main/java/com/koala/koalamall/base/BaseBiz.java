package com.koala.koalamall.base;

import android.support.annotation.NonNull;

import com.koala.koalamall.interfaces.ServerInterface;
import com.koala.koalamall.services.Service_Api;
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

/**
 * Created by Administrator on 2017/11/11 0011.
 * 网络请求基类
 */

public class BaseBiz {

    protected Service_Api service_api;


    public BaseBiz() {
        LogUtils.e("BaseBiz");
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerInterface.BASE_URL)   //设置请求地址
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();    //创建解析工厂
        //构建网络请求对象
        service_api = retrofit.create(Service_Api.class);
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
