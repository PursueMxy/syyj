package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class FmShopSearchAdapter extends HelperRecyclerViewAdapter<GoodsListBean.DataBean> {

    public FmShopSearchAdapter(Context context) {
        super(context, R.layout.list_fm_shop_search);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, GoodsListBean.DataBean item) {
        TextView tv_proname = viewHolder.getView(R.id.list_fm_shop_tv_content);
        TextView tv_price= viewHolder.getView(R.id.list_fm_shop_tv_price);
        ImageView shop_img = viewHolder.getView(R.id.list_fm_shop_img);
        tv_price.setText("¥："+item.getShop_price()+"");
        tv_proname.setText(item.getGoods_name());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+item.getOriginal_img()).into(shop_img);
    }
}
