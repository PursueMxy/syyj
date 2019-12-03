package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShopCartAdapter extends HelperRecyclerViewAdapter<Products> {

    public ShopCartAdapter(Context context) {
        super(context, R.layout.list_fm_shopcart);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Products item) {
        Products data = getData(position);
        final CheckBox cb_shopcart= viewHolder.getView(R.id.list_fm_shopcart_cb);
        //复用会重复
        cb_shopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_shopcart.setBackgroundResource(R.mipmap.icon_round_select);
            }
        });

    }
}
