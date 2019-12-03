package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CouponAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public CouponAdapter(Context context) {
        super(context, R.layout.list_coupon);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
       TextView tv_content= viewHolder.getView(R.id.list_coupon_tv_content);
        TextView tv_name= viewHolder.getView(R.id.list_coupon_tv_name);
        TextView tv_money= viewHolder.getView(R.id.list_coupon_tv_money);
        TextView tv_dt= viewHolder.getView(R.id.list_coupon_tv_dt);
        TextView tv_type= viewHolder.getView(R.id.list_coupon_tv_type);
    }
}
