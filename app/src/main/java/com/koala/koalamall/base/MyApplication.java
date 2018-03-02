package com.koala.koalamall.base;

import android.app.Activity;
import android.app.Application;

import com.koala.koalamall.bean.UserBean;
import com.koala.koalamall.interfaces.CoreKeys;
import com.koala.koalamall.utils.PreferencesLoader;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {
    public List<Activity> activityList;
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activityList = new ArrayList<>();
        PreferencesLoader.init(this);
    }

    /**
     * 获取本地用户信息
     */
    public static UserBean getUserBean() {
        return PreferencesLoader.getObject(CoreKeys.USER_BEAN, UserBean.class);
    }

    /**
     * 将用户信息存到本地
     */
    public static void setUserBean(UserBean userBean) {
        PreferencesLoader.setObject(CoreKeys.USER_BEAN, userBean);
    }

    /**
     * 加载activity
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 关闭程序，退出所有activity
     */
    public void systemExit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }
}
