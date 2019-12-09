package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.GoodsCommentBean;
import com.zhkj.syyj.CustView.CircleImageView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class AppraiseAdapter extends HelperRecyclerViewAdapter<GoodsCommentBean.DataBean> {
    public Context context;
    public AppraiseAdapter(Context context) {
        super(context, R.layout.list_appraise);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position,GoodsCommentBean.DataBean item) {
        GoodsCommentBean.DataBean data = getData(position);
        CircleImageView img_head = viewHolder.getView(R.id.list_appraise_img_head);
       TextView tv_name = viewHolder.getView(R.id.list_appraise_tv_name);
       TextView tv_typeName= viewHolder.getView(R.id.list_appraise_tv_typeName);
       TextView tv_appraise= viewHolder.getView(R.id.list_appraise_tv_appraise);
       TextView tv_assess = viewHolder.getView(R.id.list_appraise_tv_assess);
        tv_name.setText(item.getNickname());
       tv_typeName.setText(item.getAdd_time()+item.getSpec_key_name());
       tv_appraise.setText(item.getContent());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+item.getHeadimg()).into(img_head);
        if (item.getGoods_rank()==1){
            tv_assess.setText("好评");
            tv_assess.setTextColor(mContext.getResources().getColor(R.color.fffc295c));
            tv_assess.setBackgroundResource(R.drawable.text_bg_pink);
        }else if(item.getGoods_rank()==2){
            tv_assess.setText("中评");
            tv_assess.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
            tv_assess.setBackgroundResource(R.drawable.text_bg_gold);
        }else if(item.getGoods_rank()==3){
            tv_assess.setText("差评");
            tv_assess.setTextColor(mContext.getResources().getColor(R.color.text_949397));
            tv_assess.setBackgroundResource(R.drawable.text_bg_gray);
        }
    }
}
