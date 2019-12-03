package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CollectAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    private CheckBox cb_child;
    private  int buy_number=0;

    public CollectAdapter(Context context) {
        super(context, R.layout.item_shopping_car_child);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, String item) {
        String data = getData(position);
        TextView tv_number = viewHolder.getView(R.id.item_shopping_car_tv_buy_number);
        TextView tv_price_value = viewHolder.getView(R.id.item_shopping_car_tv_price_value);
        ImageView img = viewHolder.getView(R.id.item_shopping_car_image);
        TextView tv_name = viewHolder.getView(R.id.item_shopping_car_tv_name);
        TextView tv_price_key = viewHolder.getView(R.id.item_shopping_car_tv_price_key);
        ImageView img_add = viewHolder.getView(R.id.item_shopping_car_img_add);
        ImageView img_subtract = viewHolder.getView(R.id.item_shopping_car_img_subtract);
        cb_child = viewHolder.getView(R.id.cb_child);
        cb_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("点击了","是的"+position);
            }
        });
        tv_number.setText(position+"");
        tv_price_value.setText(data);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buy_number++;
            }
        });
        img_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buy_number>0){
                    buy_number--;
                }
            }
        });
    }
}
