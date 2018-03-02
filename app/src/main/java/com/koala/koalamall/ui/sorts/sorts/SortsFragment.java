package com.koala.koalamall.ui.sorts.sorts;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koala.koalamall.R;
import com.koala.koalamall.adapter.SortsAdapter;
import com.koala.koalamall.base.BaseFragment;
import com.koala.koalamall.customview.ColumnScrollView;
import com.koala.koalamall.utils.MyClicker;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class SortsFragment extends BaseFragment implements MyClicker {
    @BindView(R.id.ll_content)
    LinearLayout ll_content;
    @BindView(R.id.column_scrollView)
    ColumnScrollView column_scrollView;
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;
    //选中/未选中资源文件
    private Drawable drawable_y, drawable_n;
    //栏目当前选中下标
    private int columnSelectIndex = 0;
    private int scrllViewWidth = 0, scrollViewMiddle = 0;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_sorts;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {

    }

    @Override
    protected void onFragmentFirstVisible() {
        //设置选中状态下的drawable
        drawable_y = ContextCompat.getDrawable(getActivity(), R.drawable.text_bg_y);
        drawable_y.setBounds(0, 0, drawable_y.getMinimumWidth(), drawable_y.getMinimumHeight());
        //设为未选中状态下的drawable
        drawable_n = ContextCompat.getDrawable(getActivity(), R.drawable.text_bg_n);
        drawable_n.setBounds(0, 0, drawable_n.getMinimumWidth(), drawable_n.getMinimumHeight());
        initTabColumn();
        initData();
    }

    private void initData() {
        SortsAdapter adapter = new SortsAdapter(new ArrayList<String>(), getActivity(), this);
        rv_shop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_shop.setAdapter(adapter);
    }

    /**
     * 初始化Column栏目项
     */
    private void initTabColumn() {
        //先清空导航栏里面的view
        ll_content.removeAllViews();
        //获取数据长度
        int count = 30;
        column_scrollView.setParam(getActivity(), ll_content);
        //获取导航栏数据 循环添加进控件
        for (int i = 0; i < count; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    120);
            final TextView columnTextView = new TextView(getActivity());
            columnTextView.setTextAppearance(getActivity(), R.style.top_category_scroll_view_item_text);
            columnTextView.setGravity(Gravity.CENTER);
            columnTextView.setId(i);
            columnTextView.setText("品牌豪车" + (i + 1));
            columnTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            columnTextView.setPadding(8, 0, 8, 0);
            //设置TextView相关属性
            if (i == 0) {
                columnTextView.setTextColor(0XFF4084D7);
                columnTextView.setCompoundDrawables(null, null, null, null);
            } else {
                columnTextView.setTextColor(0XFF3D3D3D);
                columnTextView.setCompoundDrawables(null, null, null, null);
            }
            if (columnSelectIndex == i) {
                columnTextView.setSelected(true);
            }
            //TextView添加点击事件
            columnTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < ll_content.getChildCount(); i++) {
                        View localView = ll_content.getChildAt(i);
                        if (localView != v) {
                            //未选中
                            localView.setSelected(false);
                        } else {
                            //选中
                            localView.setSelected(true);
//                            layout_home.setCurrentItem(i);
                            selectTab(i);
                        }
                    }
                }
            });
            ll_content.addView(columnTextView, i, params);
        }
    }

    /**
     * 选择的Column里面的Tab
     */
    private void selectTab(int tabPosition) {
        columnSelectIndex = tabPosition;
        for (int i = 0; i < ll_content.getChildCount(); i++) {
            View checkView = ll_content.getChildAt(tabPosition);

            int x = (checkView.getTop() - getScrollViewMiddle() + (getViewHeight(checkView) / 2));
            column_scrollView.smoothScrollTo(0, x);
//            int k = checkView.getMeasuredHeight();
//            LogUtils.e("View实际高度 k=>" + k);
//            int l = checkView.getTop();
//            LogUtils.e("View所在Y轴坐标 l=>" + l);
//            int i2 = l + k / 2;
//            LogUtils.e("滑动值 i2=>" + i2);
//            column_scrollView.smoothScrollTo(0, i2);
        }
        //设置TextView相关属性
        for (int j = 0; j < ll_content.getChildCount(); j++) {
            ((TextView) ll_content.getChildAt(j)).setTextColor(0XFF3D3D3D);
            ((TextView) ll_content.getChildAt(j)).setCompoundDrawables(null, null, null, null);
        }
        ((TextView) ll_content.getChildAt(columnSelectIndex)).setTextColor(0XFF4084D7);
        ((TextView) ll_content.getChildAt(columnSelectIndex)).setCompoundDrawables(null, null, null, null);
    }

    /**
     * 返回scrollview的中间位置
     */
    private int getScrollViewMiddle() {
        if (scrollViewMiddle == 0)
            scrollViewMiddle = getScrollViewHeight() / 2;
        return scrollViewMiddle;
    }

    /**
     * 返回ScrollView的高度
     */
    private int getScrollViewHeight() {
        if (scrllViewWidth == 0)
            scrllViewWidth = column_scrollView.getBottom() - column_scrollView.getTop();
        return scrllViewWidth;
    }

    /**
     * 返回view的宽度
     */
    private int getViewHeight(View view) {
        return view.getBottom() - view.getTop();
    }

    @Override
    public void myClick(View view, int type) {

    }
}
