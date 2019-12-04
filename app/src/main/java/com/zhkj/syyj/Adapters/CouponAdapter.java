package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.CouponBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CouponAdapter extends HelperRecyclerViewAdapter<CouponBean.DataBean> {
    public Context context;
    public CouponAdapter(Context context) {
        super(context, R.layout.list_coupon);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, CouponBean.DataBean item) {
        CouponBean.DataBean data = getData(position);
        TextView tv_content= viewHolder.getView(R.id.list_coupon_tv_content);
        TextView tv_name= viewHolder.getView(R.id.list_coupon_tv_name);
        TextView tv_money= viewHolder.getView(R.id.list_coupon_tv_money);
        TextView tv_dt= viewHolder.getView(R.id.list_coupon_tv_dt);
        TextView tv_type= viewHolder.getView(R.id.list_coupon_tv_type);
        ImageView img_type = viewHolder.getView(R.id.list_coupon_img_type);
        tv_name.setText(data.getName());
        tv_content.setText(data.getCondition_title());
        tv_money.setText(data.getMoney()+"");
        tv_dt.setText(DateUtils.timeStamp2Date(data.getUse_start_time()+"")+"~"+DateUtils.timeStamp2Date(data.getUse_end_time()+""));
        tv_type.setText(data.getUse_type_title());
        if (data.getSend_type()>0){
            img_type.setVisibility(View.VISIBLE);
            if (data.getType()==1){
                img_type.setImageResource(R.mipmap.ic_already_used);
            }else {
                img_type.setImageResource(R.mipmap.ic_coupon_expired);
            }
        }else {
            img_type.setVisibility(View.GONE);
        }
    }
}
