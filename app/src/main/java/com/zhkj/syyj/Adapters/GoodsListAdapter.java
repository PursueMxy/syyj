package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class GoodsListAdapter extends HelperRecyclerViewAdapter<GoodsListBean.DataBean> {
    public Context context;

    public GoodsListAdapter(Context context) {
        super(context, R.layout.list_fm_shop_search);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, GoodsListBean.DataBean item) {
        GoodsListBean.DataBean data = getData(position);
        TextView tv_proname = viewHolder.getView(R.id.list_fm_shop_tv_content);
        TextView tv_price= viewHolder.getView(R.id.list_fm_shop_tv_price);
        ImageView shop_img = viewHolder.getView(R.id.list_fm_shop_img);
        tv_proname.setText(data.getGoods_name());
        tv_price.setText("¥ "+data.getShop_price());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(shop_img);
    }
}
