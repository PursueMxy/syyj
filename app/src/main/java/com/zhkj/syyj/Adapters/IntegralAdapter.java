package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class IntegralAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    private HelperRecyclerViewHolder viewHolder;

    public IntegralAdapter(Context context) {
        super(context, R.layout.list_integral);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        ImageView list_integral_img = viewHolder.getView(R.id.list_integral_img);
        TextView tv_price = viewHolder.getView(R.id.list_integral_tv_price);
        TextView tv_title= viewHolder.getView(R.id.list_integral_tv_title);
        viewHolder.getView(R.id.list_integral_btn_redeem_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(mContext, ForwardActivity.class));
            }
        });

    }
}
