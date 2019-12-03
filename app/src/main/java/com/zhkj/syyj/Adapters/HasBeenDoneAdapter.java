package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.DoneListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class HasBeenDoneAdapter extends HelperRecyclerViewAdapter<DoneListBean.DataBean> {

    public HasBeenDoneAdapter(Context context) {
        super(context, R.layout.list_has_been_done);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, DoneListBean.DataBean item) {
        DoneListBean.DataBean data = getData(position);
        ImageView has_been_done_img = viewHolder.getView(R.id.list_has_been_done_img);
        TextView tv_content = viewHolder.getView(R.id.list_has_been_done_tv_content);
        TextView tv_placeOrder = viewHolder.getView(R.id.list_has_been_done_tv_placeOrder);
        TextView tv_price = viewHolder.getView(R.id.list_has_been_done_tv_price);
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img());
        tv_content.setText(data.getShare_content());
        tv_price.setText("¥ "+data.getShop_price());
        tv_placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
