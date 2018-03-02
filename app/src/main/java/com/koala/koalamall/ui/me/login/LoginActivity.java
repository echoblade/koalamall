package com.koala.koalamall.ui.me.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.koalamall.R;
import com.koala.koalamall.base.BaseActivity;
import com.koala.koalamall.ui.me.register.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_look)
    ImageView ivLook;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    //记录密码可见性
    private Boolean isShow = false;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }

    @OnClick({R.id.iv_look, R.id.tv_login, R.id.tv_register, R.id.tv_forget})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_look:
                isShow = !isShow;
                if (isShow) {
                    //密码可见

                } else {
                    //密码不可见

                }
                break;
            case R.id.tv_login:
                break;
            case R.id.tv_register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget:
                break;
        }
    }
}
