package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.ReMindActivity;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.Beans.TaskListsBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.ArrayList;

public class TaskListAdapter extends HelperRecyclerViewAdapter<TaskListsBean.DataBean.TaskListBean> {
     private Context mContext;
    public TaskListAdapter(Context context) {
        super(context, R.layout.list_home_task);
        this.mContext=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, TaskListsBean.DataBean.TaskListBean item) {
        TaskListsBean.DataBean.TaskListBean data = getData(position);
        viewHolder.getView(R.id.list_home_task_btn_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WechatDialog();
            }
        });
        viewHolder.getView(R.id.list_home_task_btn_setReMind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReMindActivity.class);
                intent.putExtra("task_id",item.getId()+"");
                mContext.startActivity(intent);
            }
        });
        viewHolder.getView(R.id.list_home_task_tv_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ForwardActivity.class);
                intent.putExtra("task_id",item.getId()+"");
                intent.putExtra("content",item.getShare_content());
                ArrayList<String> share_imgs = (ArrayList<String>) item.getShare_imgs();
                intent.putStringArrayListExtra("share_imgs",share_imgs);
                mContext.startActivity(intent);
            }
        });
       TextView tv_content = viewHolder.getView(R.id.list_home_task_tv_content);
       TextView tv_price= viewHolder.getView(R.id.list_home_task_tv_price);
       TextView tv_rrp= viewHolder.getView(R.id.list_home_task_tv_rrp);
       ImageView img = viewHolder.getView(R.id.list_home_task_img);
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+item.getOriginal_img()).into(img);
        tv_content.setText(item.getShare_content());
       tv_price.setText("¥ "+item.getShop_price());
       tv_rrp.setText("¥ "+item.getMarket_price());
    }

    //转发朋友圈
    public void  WechatDialog(){
        final BottomDialog bottomDialog = new BottomDialog(mContext, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_forward_moments, null);
        inflate.findViewById(R.id.dialog_forward_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }
}
