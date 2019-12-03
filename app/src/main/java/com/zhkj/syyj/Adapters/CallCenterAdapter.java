package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhkj.syyj.R;

import java.util.List;

public class CallCenterAdapter extends RecyclerView.Adapter<CallCenterAdapter.MyViewHolder> {
    private Context context;
    private View view;
    private List<String> ages;

    public CallCenterAdapter(Context context, List<String> message){
        this.context = context;
        ages=message;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.list_call_center,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       if (position%2==0){
           holder.rl_left.setVisibility(View.VISIBLE);
           holder.rl_right.setVisibility(View.GONE);
       }else {
           holder.rl_left.setVisibility(View.GONE);
           holder.rl_right.setVisibility(View.VISIBLE);
       }
    }

    @Override
    public int getItemCount() {
        return ages.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private final RelativeLayout rl_left;
        private final RelativeLayout rl_right;
        private final ImageView left_img_head;
        private final TextView left_tv_message;
        private final ImageView right_img_head;
        private final TextView right_tv_message;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rl_left = itemView.findViewById(R.id.list_callcenter_left);
            rl_right = itemView.findViewById(R.id.list_callcenter_right);
            left_img_head = itemView.findViewById(R.id.list_callcenter_left_img_head);
            left_tv_message = itemView.findViewById(R.id.list_callcenter_left_tv_message);
            right_img_head = itemView.findViewById(R.id.list_callcenter_right_img_head);
            right_tv_message = itemView.findViewById(R.id.list_callcenter_right_tv_message);
        }
    }
}
