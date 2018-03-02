package com.koala.koalamall.ui.me.register;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.koala.koalamall.R;
import com.koala.koalamall.base.BaseActivity;
import com.koala.koalamall.ui.me.password.SetPasswordActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_next)
    TextView tvNext;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {

    }

    @OnClick(R.id.tv_next)
    public void onViewClicked() {
        Intent intent = new Intent(this, SetPasswordActivity.class);
        startActivity(intent);
    }
}
