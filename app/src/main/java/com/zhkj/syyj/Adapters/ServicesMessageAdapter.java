package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Beans.MessageNoticeBean;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class ServicesMessageAdapter extends HelperRecyclerViewAdapter<MessageNoticeBean.DataBean> {
    public Context context;
    public ServicesMessageAdapter(Context context) {
        super(context, R.layout.list_system_message);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, MessageNoticeBean.DataBean item) {
        TextView tv_title = viewHolder.getView(R.id.list_system_message_title);
        TextView tv_time = viewHolder.getView(R.id.list_system_message_time);
        TextView tv_content = viewHolder.getView(R.id.list_system_message_content);
        viewHolder.getView(R.id.list_system_message_checkdtl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        tv_title.setText(item.getMessage_title());
        tv_time.setText(item.getSend_time_text());
        tv_content.setText(item.getMessage_content());
    }
}
