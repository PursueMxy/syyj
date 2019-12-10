package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Beans.AsyncUpdateCartBean;
import com.zhkj.syyj.Beans.CarGoodsBean;
import com.zhkj.syyj.Beans.CartListBean;
import com.zhkj.syyj.Beans.CartsBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Fragments.ShopCartFragment;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ShopCartAdapter extends HelperRecyclerViewAdapter<CarGoodsBean.DataBean> {
    private final String uid;
    private final String token;
    public Context mContext;
    private List<CarGoodsBean.DataBean> liteGoodsCartBeanList=new ArrayList<>();
    private LocalBroadcastManager localBroadcastManager;
    private int GoodsNum;
    private int goods_cart_id;
    private final Intent intent;
    private ArrayList<CartsBean> cartList=new ArrayList<>();


    public ShopCartAdapter(Context context) {
        super(context, R.layout.list_fm_shopcart);
        this.mContext=context;
        SharedPreferences share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        intent = new Intent(ShopCartFragment.LOCAL_BROADCAST);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, CarGoodsBean.DataBean item) {
        CarGoodsBean.DataBean data = getData(position);
        localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
        ImageView shopcart_img = viewHolder.getView(R.id.list_fm_shopcart_img);
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
        if (data.getSelected()==1){
            img_cb.setImageResource(R.mipmap.icon_round_select);
        }else {
            img_cb.setImageResource(R.mipmap.icon_round);
        }
        img_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new GsonBuilder().create();
                String cart="";
                cartList.clear();
                if (data.getSelected()==1){
                    cartList.add(new CartsBean(data.getId(), data.getGoods_num(), 0));
                    cart= gson.toJson(cartList);
                   img_cb.setImageResource(R.mipmap.icon_round);
                }else if (data.getSelected()==0){
                    cartList.add(new CartsBean(data.getId(), data.getGoods_num(), 1));
                    cart= gson.toJson(cartList);
                    img_cb.setImageResource(R.mipmap.icon_round_select);
                }
                intent.putExtra("query_city", true);   //通知fragment,让它去调用queryCity()方法
                intent.putExtra("cartLists",cart);
                localBroadcastManager.sendBroadcast(intent);   //发送本地广播   通知fragment该刷新了
            }
        });
        viewHolder.getView(R.id.list_fm_shopcart_tv_lesson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsNum=data.getGoods_num();
                goods_cart_id = data.getId();
               if (data.getGoods_num()>1){
                   GoodsNum=GoodsNum-1;
                   ChangeNum();
               }else {
               }
            }
        });
        viewHolder.getView(R.id.list_fm_shopcart_tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsNum=data.getGoods_num();
                goods_cart_id = data.getId();
                GoodsNum=GoodsNum+1;
                ChangeNum();
            }
        });
    }

    public void ChangeNum(){
        OkGo.<String>post(RequstUrlUtils.URL.ChangeNum)
                .params("uid",uid)
                .params("token",token)
                .params("id",goods_cart_id)
                .params("goods_num",GoodsNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            intent.putExtra("query_city", true);   //通知fragment,让它去调用queryCity()方法
                            localBroadcastManager.sendBroadcast(intent);
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }



}
