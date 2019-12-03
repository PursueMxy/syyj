package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerLeftAdapter extends RecyclerView.Adapter<RecyclerLeftAdapter.ViewHolder> {

    public Context mContext;
    public int SltItem=0;
    List<CategoryListBean.DataBean> dataList=new ArrayList<>();
    public RecyclerLeftAdapter(Context context, List<CategoryListBean.DataBean> data){
        mContext=context;
        this.dataList=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_shop_left, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (SltItem==position) {
            holder.left_text.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
        }else {
            holder.left_text.setTextColor(mContext.getResources().getColor(R.color.text_black));
        }
        holder.left_text.setText(dataList.get(position).getName());
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

    public void refreshData(List<CategoryListBean.DataBean> data){
        this.dataList=data;
    }

    public void refreshSlt(int item){
    this.SltItem=item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView left_text;
        public ViewHolder(View itemView) {
            super(itemView);
            left_text = itemView.findViewById(R.id.list_shop_left_text);
        }

    }

    private OnItemClickListener mOnItemClickListener;//声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
