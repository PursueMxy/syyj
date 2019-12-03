package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.LiteGoodsCartBean;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.Fragments.ShopCartFragment;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ShopCartAdapter extends HelperRecyclerViewAdapter<LiteGoodsCartBean> {
     public Context mContext;
    private List<LiteGoodsCartBean> liteGoodsCartBeanList=new ArrayList<>();
    private LocalBroadcastManager localBroadcastManager;
    private int GoodsNum;

    public ShopCartAdapter(Context context) {
        super(context, R.layout.list_fm_shopcart);
        this.mContext=context;
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, LiteGoodsCartBean item) {
        final LiteGoodsCartBean data = getData(position);
        localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
        final Intent intent = new Intent(ShopCartFragment.LOCAL_BROADCAST);
        ImageView shopcart_img = viewHolder.getView(R.id.list_fm_shopcart_img);
        Log.e("更新",GoodsNum+data.getGoods_name());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(shopcart_img);
        TextView tv_content = viewHolder.getView(R.id.list_fm_shopcart_tv_content);
        tv_content.setText(data.getGoods_name()+"");
        TextView tv_select_num = viewHolder.getView(R.id.list_fm_shopcart_tv_select_num);
        tv_select_num.setText(data.getGoods_num()+"");
        TextView tv_spec_key_name= viewHolder.getView(R.id.list_fm_shopcart_tv_spec_key_name);
        tv_spec_key_name.setText(data.getSpec_key_name());
        TextView tv_price= viewHolder.getView(R.id.list_fm_shopcart_tv_price);
        tv_price.setText("¥ "+data.getGoods_price());
        final ImageView img_cb = viewHolder.getView(R.id.list_fm_shopcart_cb);
        if (data.getSlt_goods().equals("true")){
            img_cb.setImageResource(R.mipmap.icon_round_select);
        }else {
            img_cb.setImageResource(R.mipmap.icon_round);
        }
        img_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiteGoodsCartBean liteGoodsCartBean = new LiteGoodsCartBean();
                if (data.getSlt_goods().equals("true")){
                 liteGoodsCartBean.setSlt_goods("false");
                 img_cb.setImageResource(R.mipmap.icon_round);
                }else if (data.getSlt_goods().equals("false")){
                  liteGoodsCartBean.setSlt_goods("true");
                  img_cb.setImageResource(R.mipmap.icon_round_select);
                }
                liteGoodsCartBean.updateAll("goods_cart_id="+ data.getGoods_cart_id());
                intent.putExtra("query_city", true);   //通知fragment,让它去调用queryCity()方法
                localBroadcastManager.sendBroadcast(intent);   //发送本地广播   通知fragment该刷新了
            }
        });
        viewHolder.getView(R.id.list_fm_shopcart_tv_lesson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (data.getGoods_num()>1){
                   LiteGoodsCartBean liteGoodsCartBean = new LiteGoodsCartBean();
                   liteGoodsCartBean.setGoods_num(data.getGoods_num()-1);
                   liteGoodsCartBean.updateAll("goods_cart_id="+ data.getGoods_cart_id());
                   intent.putExtra("query_city", true);   //通知fragment,让它去调用queryCity()方法
                   localBroadcastManager.sendBroadcast(intent);
               }else {
               }
            }
        });
        viewHolder.getView(R.id.list_fm_shopcart_tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiteGoodsCartBean liteGoodsCartBean = new LiteGoodsCartBean();
                liteGoodsCartBean.setGoods_num(data.getGoods_num()+1);
                liteGoodsCartBean.updateAll("goods_cart_id="+ data.getGoods_cart_id());
                intent.putExtra("query_city", true);   //通知fragment,让它去调用queryCity()方法
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }
}
