package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Beans.CouponCenterBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ShoppingBrokerAdapter extends HelperRecyclerViewAdapter<CouponCenterBean.DataBean> {
    public Context context;
    public ShoppingBrokerAdapter(Context context) {
        super(context, R.layout.list_shopping_broker);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, CouponCenterBean.DataBean item) {
        TextView tv_content = viewHolder.getView(R.id.list_shopping_broker_tv_content);
        TextView tv_dt = viewHolder.getView(R.id.list_shopping_broker_tv_dt);
        TextView tv_money = viewHolder.getView(R.id.list_shopping_broker_tv_money);
        TextView tv_name = viewHolder.getView(R.id.list_shopping_broker_tv_name);
        TextView tv_price = viewHolder.getView(R.id.list_shopping_broker_tv_price);
        TextView tv_type = viewHolder.getView(R.id.list_shopping_broker_tv_type);
        tv_content.setText(item.getCondition_title()+"");
        tv_money.setText(item.getMoney()+"");
        tv_price.setText("¥ "+item.getPrice()+"\n立即购买");
        tv_dt.setText(DateUtils.timeStamp2Date(item.getUse_start_time()+"")+"~"+DateUtils.timeStamp2Date(item.getUse_end_time()+""));
         tv_name.setText(item.getCondition_title());
         tv_type.setText(item.getType_title());

    }
}
