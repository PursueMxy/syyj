package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhkj.syyj.Beans.CouponBean;
import com.zhkj.syyj.Beans.PlaceOrderBean;
import com.zhkj.syyj.Beans.UsableCouponBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class UsableCouponAdapter extends HelperRecyclerViewAdapter<PlaceOrderBean.DataBean.UserCartCouponListBean> {
    public Context context;
    public UsableCouponAdapter(Context context) {
        super(context, R.layout.list_coupon);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, PlaceOrderBean.DataBean.UserCartCouponListBean item) {
        PlaceOrderBean.DataBean.UserCartCouponListBean data = getData(position);
        RelativeLayout coupon_rl= viewHolder.getView(R.id.list_coupon_rl);
        TextView tv_content= viewHolder.getView(R.id.list_coupon_tv_content);
        TextView tv_name= viewHolder.getView(R.id.list_coupon_tv_name);
        TextView tv_money= viewHolder.getView(R.id.list_coupon_tv_money);
        TextView tv_dt= viewHolder.getView(R.id.list_coupon_tv_dt);
        TextView tv_type= viewHolder.getView(R.id.list_coupon_tv_type);
        ImageView img_type = viewHolder.getView(R.id.list_coupon_img_type);
        TextView tv_fg= viewHolder.getView(R.id.list_coupon_tv_fg);
        tv_name.setText(data.getCoupon().getName());
        tv_content.setText(data.getCoupon().getCondition_title());
        tv_money.setText(data.getCoupon().getMoney()+"");
        tv_dt.setText(DateUtils.timeStamp2Date(data.getCoupon().getUse_start_time()+"")+"~"+DateUtils.timeStamp2Date(data.getCoupon().getUse_end_time()+""));
        tv_type.setText(data.getCoupon().getType_title());
            tv_content.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_name.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_money.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_dt.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_type.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_fg.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_type.setBackgroundColor(mContext.getResources().getColor(R.color.text_efb134));
            coupon_rl.setBackgroundColor(mContext.getResources().getColor(R.color.text_white));
            img_type.setVisibility(View.GONE);
    }
}
