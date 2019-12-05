package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.PlaceOrderIntegralActivity;
import com.zhkj.syyj.Beans.IntegralListBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class IntegralAdapter extends HelperRecyclerViewAdapter<IntegralListBean.DataBean> {
    public Context context;
    private HelperRecyclerViewHolder viewHolder;
    private int SelectNum;

    public IntegralAdapter(Context context) {
        super(context, R.layout.list_integral);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, IntegralListBean.DataBean item) {
        IntegralListBean.DataBean data = getData(position);
        ImageView list_integral_img = viewHolder.getView(R.id.list_integral_img);
        TextView tv_price = viewHolder.getView(R.id.list_integral_tv_price);
        TextView tv_title= viewHolder.getView(R.id.list_integral_tv_title);
        viewHolder.getView(R.id.list_integral_btn_redeem_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedeemNowDialog();
            }
        });
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(list_integral_img);
        tv_price.setText(data.getExchange_integral()+"");
        tv_title.setText(data.getGoods_name());

    }

    //立即兑换弹出窗
    public void  RedeemNowDialog(){
        final BottomDialog bottomDialog = new BottomDialog(mContext, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
        final TextView tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
        final TextView tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
        inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                mContext.startActivity(new Intent(mContext, PlaceOrderIntegralActivity.class));
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_lesson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SelectNum>1){
                    SelectNum=--SelectNum;
                    tv_select_num.setText(SelectNum+"");
                    tv_selectedNum.setText("已选10ml"+SelectNum);
                }else {
                    ToastUtils.showToast(mContext,"换购数量不能小于1");
                }
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectNum=++SelectNum;
                tv_select_num.setText(SelectNum+"");
                tv_selectedNum.setText("已选10ml,"+SelectNum);
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }
}
