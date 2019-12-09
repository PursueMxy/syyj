package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.NewsListBean;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class InformationChoiceAdapter extends HelperRecyclerViewAdapter<NewsListBean.DataBean> {

    public InformationChoiceAdapter(Context context) {
        super(context, R.layout.list_information_choice);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, NewsListBean.DataBean item) {
        NewsListBean.DataBean data = getData(position);
        TextView tv_title = viewHolder.getView(R.id.list_information_choice_tv_title);
        TextView tv_time= viewHolder.getView(R.id.list_information_choice_tv_time);
        TextView tv_content = viewHolder.getView(R.id.list_information_choice_tv_content);
        ImageView choice_img = viewHolder.getView(R.id.list_information_choice_img);
        tv_title.setText(data.getTitle());
        tv_time.setText(data.getAdd_time());
        tv_content.setText(data.getDescription());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST + data.getThumb()).into(choice_img);
    }
}
