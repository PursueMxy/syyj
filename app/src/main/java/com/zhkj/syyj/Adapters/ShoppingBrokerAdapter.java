package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShoppingBrokerAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public ShoppingBrokerAdapter(Context context) {
        super(context, R.layout.list_shopping_broker);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        TextView tv_content = viewHolder.getView(R.id.list_shopping_broker_tv_content);
        TextView tv_dt = viewHolder.getView(R.id.list_shopping_broker_tv_dt);
        TextView tv_money = viewHolder.getView(R.id.list_shopping_broker_tv_money);
        TextView tv_name = viewHolder.getView(R.id.list_shopping_broker_tv_name);
        TextView tv_price = viewHolder.getView(R.id.list_shopping_broker_tv_price);
        TextView tv_type = viewHolder.getView(R.id.list_shopping_broker_tv_type);

    }
}
