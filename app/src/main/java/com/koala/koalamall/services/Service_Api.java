package com.koala.koalamall.services;


import com.koala.koalamall.bean.BaseBean;
import com.koala.koalamall.bean.UserBean;
import com.koala.koalamall.interfaces.ServerInterface;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/11/11 0011.
 * 所有请求接口定义基类
 */

public interface Service_Api {

    //注册
    @POST(ServerInterface.REGISTER)
    @FormUrlEncoded
    Call<BaseBean<UserBean>> register(@FieldMap Map<String, String> map);

}
