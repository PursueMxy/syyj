package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class GoodsListAdapter extends HelperRecyclerViewAdapter<GoodsListBean.DataBean> {
    public Context context;

    public GoodsListAdapter(Context context) {
        super(context, R.layout.item_shopping_car_child);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, GoodsListBean.DataBean item) {
    }
}
