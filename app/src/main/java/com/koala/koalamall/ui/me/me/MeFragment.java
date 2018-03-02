package com.koala.koalamall.ui.me.me;

import android.content.Intent;
import android.widget.TextView;

import com.koala.koalamall.R;
import com.koala.koalamall.base.BaseFragment;
import com.koala.koalamall.ui.me.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_me;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {

    }

    @Override
    protected void onFragmentFirstVisible() {

    }

    @OnClick(R.id.tv_login)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
