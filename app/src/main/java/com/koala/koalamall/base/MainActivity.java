package com.koala.koalamall.base;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koala.koalamall.R;
import com.koala.koalamall.adapter.PagerAdapter;
import com.koala.koalamall.customview.NoScrollMainPager;
import com.koala.koalamall.ui.cart.cart.CartFragment;
import com.koala.koalamall.ui.home.home.HomeFragment;
import com.koala.koalamall.ui.me.me.MeFragment;
import com.koala.koalamall.ui.order.order.OrderFragment;
import com.koala.koalamall.ui.sorts.sorts.SortsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @BindView(R.id.layout_home)
    NoScrollMainPager layout_home;
    @BindView(R.id.iv_home)
    ImageView iv_home;
    @BindView(R.id.tv_home)
    TextView tv_home;
    @BindView(R.id.iv_sorts)
    ImageView iv_sorts;
    @BindView(R.id.tv_sorts)
    TextView tv_sorts;
    @BindView(R.id.iv_cart)
    ImageView iv_cart;
    @BindView(R.id.tv_cart)
    TextView tv_cart;
    @BindView(R.id.iv_order)
    ImageView iv_order;
    @BindView(R.id.tv_order)
    TextView tv_order;
    @BindView(R.id.iv_me)
    ImageView iv_me;
    @BindView(R.id.tv_me)
    TextView tv_me;
    private long exitTime = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    protected void init() {
        initListener();
        initFragment();
    }

    private void initListener() {
        layout_home.addOnPageChangeListener(this);
        layout_home.setOffscreenPageLimit(4);
    }

    private void initFragment() {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        fragmentList.add(homeFragment);
        SortsFragment sortsFragment = new SortsFragment();
        fragmentList.add(sortsFragment);
        CartFragment cartFragment = new CartFragment();
        fragmentList.add(cartFragment);
        OrderFragment orderFragment = new OrderFragment();
        fragmentList.add(orderFragment);
        MeFragment meFragment = new MeFragment();
        fragmentList.add(meFragment);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), fragmentList);
        layout_home.setAdapter(adapter);
    }

    @OnClick({R.id.ll_home, R.id.ll_sorts, R.id.ll_cart, R.id.ll_order, R.id.ll_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                setTabSelection(0);
                break;
            case R.id.ll_sorts:
                setTabSelection(1);
                break;
            case R.id.ll_cart:
                setTabSelection(2);
                break;
            case R.id.ll_order:
                setTabSelection(3);
                break;
            case R.id.ll_me:
                setTabSelection(4);
                break;
        }
    }

    public void setTabSelection(int index) {
        // 每次选中之前先清除掉上次的选中状态
        clearSelection();
        switch (index) {
            case 0:
                iv_home.setImageResource(R.drawable.menu_home_y);
                tv_home.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case 1:
                iv_sorts.setImageResource(R.drawable.menu_sorts_y);
                tv_sorts.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case 2:
                iv_cart.setImageResource(R.drawable.menu_cart_y);
                tv_cart.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case 3:
                iv_order.setImageResource(R.drawable.menu_order_y);
                tv_order.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case 4:
                iv_me.setImageResource(R.drawable.menu_me_y);
                tv_me.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
        }
        layout_home.setCurrentItem(index);
    }

    private void clearSelection() {
        iv_home.setImageResource(R.drawable.menu_home_n);
        iv_sorts.setImageResource(R.drawable.menu_sorts_n);
        iv_cart.setImageResource(R.drawable.menu_cart_n);
        iv_order.setImageResource(R.drawable.menu_order_n);
        iv_me.setImageResource(R.drawable.menu_me_n);
        tv_home.setTextColor(0XFF333333);
        tv_sorts.setTextColor(0XFF333333);
        tv_cart.setTextColor(0XFF333333);
        tv_order.setTextColor(0XFF333333);
        tv_me.setTextColor(0XFF333333);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTabSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 2次退出效果
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
