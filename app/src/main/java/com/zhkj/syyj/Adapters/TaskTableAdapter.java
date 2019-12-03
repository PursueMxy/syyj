package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.Beans.TaskCategoryBean;
import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;


public class TaskTableAdapter extends RecyclerView.Adapter<TaskTableAdapter.ViewHolder> {

    public Context mContext;
    public int sltItem=0;
    List<TaskCategoryBean.DataBean> dataList=new ArrayList<>();
    public TaskTableAdapter(Context context, List<TaskCategoryBean.DataBean> data){
        mContext=context;
        this.dataList=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_tible_title, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        if (position==sltItem) {
            holder.tv_title.setBackground(mContext.getResources().getDrawable(R.drawable.myorder_choosed_color));
            holder.tv_title.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
        }else {
            holder.tv_title.setBackground(mContext.getResources().getDrawable(R.drawable.myorder_nochoosed_color));
            holder.tv_title.setTextColor(mContext.getResources().getColor(R.color.tab_e6e6e6));
        }
        holder.tv_title.setText(dataList.get(position).getName());
        View itemView = ((RelativeLayout) holder.itemView).getChildAt(0);
        if (mOnItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.list_table_tv_title);
        }

    }

    public void refreshData(int SltItem){
        Log.e("执行",SltItem+"HH");
        this.sltItem=SltItem;
    }

    private OnItemClickListener mOnItemClickListener;//声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
