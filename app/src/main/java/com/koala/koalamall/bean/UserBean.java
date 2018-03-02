package com.koala.koalamall.bean;

import com.koala.koalamall.base.BaseValue;

/**
 * 用户个人信息
 */
public class UserBean extends BaseValue {
    private String token;
    private String username;
    private String phone;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
