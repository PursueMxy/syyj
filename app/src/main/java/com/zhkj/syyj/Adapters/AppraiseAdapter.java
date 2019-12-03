package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.CustView.CircleImageView;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class AppraiseAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public AppraiseAdapter(Context context) {
        super(context, R.layout.list_appraise);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        CircleImageView img_head = viewHolder.getView(R.id.list_appraise_img_head);
       TextView tv_name = viewHolder.getView(R.id.list_appraise_tv_name);
       TextView tv_typeName= viewHolder.getView(R.id.list_appraise_tv_typeName);
       TextView tv_appraise= viewHolder.getView(R.id.list_appraise_tv_appraise);
    }
}
