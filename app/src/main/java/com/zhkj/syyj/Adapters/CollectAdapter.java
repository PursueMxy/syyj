package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Activitys.CollectActivity;
import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.Beans.LiteCollectBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

public class CollectAdapter extends HelperRecyclerViewAdapter<LiteCollectBean> {
    private final Intent intent;
    private final LocalBroadcastManager localBroadcastManager;
    public Context context;

    public CollectAdapter(Context context) {
        super(context, R.layout.list_collect_item);
        this.context=context;
        intent = new Intent(CollectActivity.LOCAL_BROADCAST);
        localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, LiteCollectBean item) {
        LiteCollectBean data = getData(position);
        ImageView item_img = viewHolder.getView(R.id.list_collect_item_img);
        ImageView img_slt = viewHolder.getView(R.id.list_collect_item_img_slt);
        TextView tv_content = viewHolder.getView(R.id.list_collect_item_tv_content);
        TextView tv_price = viewHolder.getView(R.id.list_collect_item_tv_price);
        TextView tv_spec_key_name = viewHolder.getView(R.id.list_collect_item_tv_spec_key_name);
        if (data.getIsShow().equals("true")){
            img_slt.setVisibility(View.VISIBLE);
        }else {
            img_slt.setVisibility(View.GONE);
        }
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(item_img);
        tv_content.setText(data.getGoods_name());
        tv_price.setText("¥ "+data.getShop_price());
        tv_spec_key_name.setText("");
        if (data.getCollect_slt().equals("true")){
            img_slt.setImageResource(R.mipmap.icon_round_select);
        }else if (data.getCollect_slt().equals("false")){
            img_slt.setImageResource(R.mipmap.icon_round);
        }
        img_slt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (data.getCollect_slt().equals("false")){
                    LiteCollectBean liteCollectBean = new LiteCollectBean();
                    liteCollectBean.setCollect_slt("true");
                    liteCollectBean.updateAll("collect_id="+data.getCollect_id());
                }else if (data.getCollect_slt().equals("true")){
                    LiteCollectBean liteCollectBean = new LiteCollectBean();
                    liteCollectBean.setCollect_slt("false");
                    liteCollectBean.updateAll("collect_id="+data.getCollect_id());
                }
                intent.putExtra("collect", true);   //通知fragment,让它去调用queryCity()方法
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
}
