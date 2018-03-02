package com.koala.koalamall.base;

/**
 * Created by Administrator on 2017/9/20.
 */

public interface BeanCallback<T> {

    void onSuccess(T response);

    void onError(String msg);
}
