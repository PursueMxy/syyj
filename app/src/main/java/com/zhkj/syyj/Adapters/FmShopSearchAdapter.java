package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class FmShopSearchAdapter extends HelperRecyclerViewAdapter<Products> {

    public FmShopSearchAdapter(Context context) {
        super(context, R.layout.list_fm_shop_search);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Products item) {
        Products data = getData(position);
        TextView tv_proname = viewHolder.getView(R.id.list_fm_shop_tv_content);
        TextView tv_price= viewHolder.getView(R.id.list_fm_shop_tv_price);
        ImageView shop_img = viewHolder.getView(R.id.list_fm_shop_img);
    }
}
