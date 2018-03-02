package com.koala.koalamall.base;


import com.koala.koalamall.bean.BaseBean;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public interface OnBaseListener {

    /**
     * 服务器响应
     *
     * @param result
     */
    void onResponse(BaseBean result);

    /**
     * 服务器未响应
     *
     * @param e
     */
    void onFailure(String e);
}
