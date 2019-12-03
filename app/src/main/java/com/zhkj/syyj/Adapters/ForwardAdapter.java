package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ForwardAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public ForwardAdapter(Context context) {
        super(context, R.layout.list_forward);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        ImageView forward_img= viewHolder.getView(R.id.list_forward_img);
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST + data).into(forward_img);
    }
}
