package com.koala.koalamall.base;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */

public abstract class ListItemAdapter<T> extends BaseAdapter {

    protected Context mContext;
    private List<T> mList;


    public ListItemAdapter(Context mContext, List<T> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
