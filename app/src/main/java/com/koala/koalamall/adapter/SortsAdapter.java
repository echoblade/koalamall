package com.koala.koalamall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koala.koalamall.R;
import com.koala.koalamall.utils.MyClicker;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SortsAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private List<String> list;
    private Context mContext;
    private MyClicker myClicker;


    public SortsAdapter(List<String> list, Context mContext, MyClicker myClicker) {
        this.mContext = mContext;
        this.myClicker = myClicker;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.item_sorts, null);
        AutoUtils.autoSize(convertView);
        return new ViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
//        return list == null ? 0 : list.size();
        return 20;
    }

    @Override
    public void onClick(View v) {
        myClicker.myClick(v, 0);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_introduce)
        TextView tv_introduce;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
