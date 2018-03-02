package com.koala.koalamall.bean;

import com.koala.koalamall.base.BaseValue;

/**
 * Created by Administrator on 2017/8/12.
 * 请求返回值基类
 */

public class BaseBean<T> extends BaseValue {
    public T data;      //不同实体类
    public int code;    //本次请求返回码
    public String message;  //本次请求返回信息
}
