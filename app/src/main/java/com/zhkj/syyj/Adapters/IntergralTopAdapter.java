package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;

public class IntergralTopAdapter extends RecyclerView.Adapter<IntergralTopAdapter.ViewHolder> {

    private Context mContext;
    private List<String> list=new ArrayList<>();

    public IntergralTopAdapter(Context context, List<String> list){
          this.mContext=context;
          this.list=list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_integral_top, parent,
                false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
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
        if (position==0){
            holder.tv_typename.setBackgroundResource(R.drawable.myorder_choosed_color);
            holder.tv_typename.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
        }else {
            holder.tv_typename.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            holder.tv_typename.setTextColor(mContext.getResources().getColor(R.color.text_fdfdfd));
        }
        holder.tv_typename.setText(list.get(position));


    }

    private OnItemClickListener mOnItemClickListener;//声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv_typename;

        public ViewHolder(View itemView) {
        super(itemView);
            tv_typename = itemView.findViewById(R.id.integral_top_tv_typename);
    }
}
}
