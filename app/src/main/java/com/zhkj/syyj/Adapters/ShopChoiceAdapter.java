package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.HomeIndexBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShopChoiceAdapter extends HelperRecyclerViewAdapter<HomeIndexBean.DataBean.GoodsBean> {

    public ShopChoiceAdapter(Context context) {
        super(context, R.layout.list_home_shop_choice);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, HomeIndexBean.DataBean.GoodsBean item) {
        HomeIndexBean.DataBean.GoodsBean data = getData(position);
        TextView tv_price= viewHolder.getView(R.id.list_home_shop_choice_tv_price);
        TextView tv_detail = viewHolder.getView(R.id.list_home_shop_choice_tv_detail);
        ImageView choice_img = viewHolder.getView(R.id.list_home_shop_choice_img);
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(choice_img);
        tv_price.setText("¥ "+data.getShop_price());
        tv_detail.setText(data.getGoods_name());
    }
}
