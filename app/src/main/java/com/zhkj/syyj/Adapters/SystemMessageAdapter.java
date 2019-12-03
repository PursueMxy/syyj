package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class SystemMessageAdapter extends HelperRecyclerViewAdapter<String> {
    public Context context;
    public SystemMessageAdapter(Context context) {
        super(context, R.layout.list_system_message);
        this.context=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        String data = getData(position);
        TextView tv_title = viewHolder.getView(R.id.list_system_message_title);
        TextView tv_time = viewHolder.getView(R.id.list_system_message_time);
        TextView tv_content = viewHolder.getView(R.id.list_system_message_content);
        viewHolder.getView(R.id.list_system_message_checkdtl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
