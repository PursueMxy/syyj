package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class IntegralDeatilAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public IntegralDeatilAdapter(Context context) {
        super(context, R.layout.list_integral_detail);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        TextView tv_type = viewHolder.getView(R.id.list_integral_detail_tv_type);
        TextView tv_time = viewHolder.getView(R.id.list_integral_detail_tv_time);
        TextView tv_number = viewHolder.getView(R.id.list_integral_detail_tv_number);
    }
}
