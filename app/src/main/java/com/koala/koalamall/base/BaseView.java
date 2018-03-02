package com.koala.koalamall.base;


import com.koala.koalamall.bean.BaseBean;

/**
 * Created by Administrator on 2017/11/11 0011.
 */

public interface BaseView {

    /**
     * 服务器返回的不是 200
     * <p>
     * 服务器返回   400 403 404 405 500
     */
    void onViewFailure(BaseBean result);

    /**
     * 服务断开
     */
    void onServerFailure(String e);
}
