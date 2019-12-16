package com.zhkj.syyj.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Activitys.PlaceOrderActivity;
import com.zhkj.syyj.Adapters.ShopCartAdapter;
import com.zhkj.syyj.Beans.AsyncUpdateCartBean;
import com.zhkj.syyj.Beans.CarGoodsBean;
import com.zhkj.syyj.Beans.CardOrderBean;
import com.zhkj.syyj.Beans.CartListBean;
import com.zhkj.syyj.Beans.CartsBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCartFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ShopCartAdapter shopCartAdapter;
    private String uid;
    private String token;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    /**
     * 发送本地广播的action
     */
    public static final String LOCAL_BROADCAST = "com.zhkj.syyj.LOCAL_BROADCAST";
    private LocalReceiver localReceiver;
    private List<CarGoodsBean.DataBean> goodsCartTrueList=new ArrayList<>();
    private List<CarGoodsBean.DataBean> goodsCartFalseList=new ArrayList<>();
    private TextView tv_sumMoney;
    private boolean SLT_All=false;
    private ImageView img_all;
    private Button btn_delete;
    private Button btn_settle;
    private boolean IsManage=false;
    private ArrayList<CartsBean> cartList=new ArrayList<>();
    private CustomProgressDialog progressDialog;

    public ShopCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop_cart, container, false);
        mContext = getContext();
        SharedPreferences share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        InitUI();
        InitData();
        AsyncUpdateCart("");
        return inflate;
    }

    public void InitData() {
        LoadingDialogShow();
        OkGo.<String>get(RequstUrlUtils.URL.CartIndex)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LoadingDialogClose();
                        CarGoodsBean carGoodsBean = new GsonBuilder().create().fromJson(response.body(), CarGoodsBean.class);
                        goodsCartTrueList.clear();
                        goodsCartFalseList.clear();
                        if (carGoodsBean.getCode()==1) {
                            List<CarGoodsBean.DataBean> data = carGoodsBean.getData();
                            goodsCartTrueList=data;
                        }
                        for (int a=0;a<goodsCartTrueList.size();a++){
                            if (goodsCartTrueList.get(a).getSelected()==0){
                                goodsCartFalseList.add(goodsCartTrueList.get(a));
                            }
                        }
                        if (goodsCartTrueList.size()>0&&goodsCartFalseList.size()==0){
                            SLT_All=true;
                            img_all.setImageResource(R.mipmap.icon_round_select);
                        }else {
                            SLT_All=false;
                            img_all.setImageResource(R.mipmap.icon_round);
                        }
                        shopCartAdapter.setListAll(goodsCartTrueList);
                        shopCartAdapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void InitUI() {
        //获取LocalBroadcastManager   本地广播管理者实例
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        localReceiver = new LocalReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(LOCAL_BROADCAST);   //添加action
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
        tv_sumMoney = inflate.findViewById(R.id.fm_shop_cart_sunMoney);
        btn_delete = inflate.findViewById(R.id.fm_shop_cart_btn_delete);
        btn_settle = inflate.findViewById(R.id.fm_shop_cart_btn_settle);
        mRecyclerView = inflate.findViewById(R.id.fm_shop_cart_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        shopCartAdapter = new ShopCartAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setFootViewText("拼命加载中","已经全部");
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                InitData();
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        shopCartAdapter.setListAll(goodsCartTrueList);
        mRecyclerView.setAdapter(shopCartAdapter);
        TextView cb_all = inflate.findViewById(R.id.fm_shop_cart_cb_all);
        img_all = inflate.findViewById(R.id.fm_shop_cart_img);
        img_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.clear();
                if (!SLT_All){
                    SLT_All=!SLT_All;
                    for (int a=0;a<goodsCartTrueList.size();a++){
                        cartList.add(new CartsBean(goodsCartTrueList.get(a).getId(), goodsCartTrueList.get(a).getGoods_num(), 1));
                    }
                    AsyncUpdateCart(cartList);
                    img_all.setImageResource(R.mipmap.icon_round_select);
                }else {
                    SLT_All=!SLT_All;
                    for (int a=0;a<goodsCartTrueList.size();a++){
                        cartList.add(new CartsBean(goodsCartTrueList.get(a).getId(), goodsCartTrueList.get(a).getGoods_num(), 0));
                    }
                    AsyncUpdateCart(cartList);
                    img_all.setImageResource(R.mipmap.icon_round);
                }
            }
        });
        cb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList.clear();
                cartList.clear();
                if (!SLT_All){
                    SLT_All=!SLT_All;
                    for (int a=0;a<goodsCartTrueList.size();a++){
                        cartList.add(new CartsBean(goodsCartTrueList.get(a).getId(), goodsCartTrueList.get(a).getGoods_num(), 1));
                    }
                    AsyncUpdateCart(cartList);
                    img_all.setImageResource(R.mipmap.icon_round_select);
                }else {
                    SLT_All=!SLT_All;
                    for (int a=0;a<goodsCartTrueList.size();a++){
                        cartList.add(new CartsBean(goodsCartTrueList.get(a).getId(), goodsCartTrueList.get(a).getGoods_num(), 0));
                    }
                    AsyncUpdateCart(cartList);
                    img_all.setImageResource(R.mipmap.icon_round);
                }
            }
        });
        //管理
        inflate.findViewById(R.id.fm_shop_cart_manage).setOnClickListener(this);
        inflate.findViewById(R.id.fm_shop_cart_btn_delete).setOnClickListener(this);
        inflate.findViewById(R.id.fm_shop_cart_btn_settle).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_shop_cart_btn_delete:
                DeleteCart();
                break;
            case R.id.fm_shop_cart_btn_settle:
                OffHandPay();
                break;
            case R.id.fm_shop_cart_manage:
                if (!IsManage){
                    btn_settle.setVisibility(View.GONE);
                    tv_sumMoney.setVisibility(View.GONE);
                    btn_delete.setVisibility(View.VISIBLE);
                    IsManage=!IsManage;
                }else {
                    btn_delete.setVisibility(View.GONE);
                    tv_sumMoney.setVisibility(View.VISIBLE);
                    btn_settle.setVisibility(View.VISIBLE);
                    IsManage=!IsManage;
                }
                break;
                default:
                    break;
        }
    }

    private void DeleteCart() {
        String cart_ids="";
        for (int a=0;a<goodsCartTrueList.size();a++) {
            if (a==0){
                cart_ids=goodsCartTrueList.get(a).getId()+"";
            }else {
                cart_ids=cart_ids+","+goodsCartTrueList.get(a).getId();
            }
        }
        OkGo.<String>post(RequstUrlUtils.URL.CartDelete)
                .params("uid",uid)
                .params("token",token)
                .params("cart_ids",cart_ids)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            InitData();
                            AsyncUpdateCart("");
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }


    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(!action.equals(LOCAL_BROADCAST)){
                return ;
            }
            boolean queryCity = intent.getBooleanExtra("query_city",false);  //判断是否需要调用查询城市
            //如果是接收到需要查询城市信息的广播   则去执行该方法
            if(queryCity){
                String cartLists = intent.getStringExtra("cartLists");
                try {
                    AsyncUpdateCart(cartLists);
                }catch (Exception e){
                    AsyncUpdateCart("");
                }
            }

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);    //取消广播的注册
    }

    public void  AsyncUpdateCart(String cart){
        LoadingDialogShow();
        OkGo.<String>post(RequstUrlUtils.URL.AsyncUpdateCart)
                .params("uid",uid)
                .params("token",token)
                .params("cart",cart)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LoadingDialogClose();
                        AsyncUpdateCartBean asyncUpdateCartBean = new GsonBuilder().create().fromJson(response.body(), AsyncUpdateCartBean.class);
                        if (asyncUpdateCartBean.getCode()==1){
                            InitData();
                            AsyncUpdateCartBean.DataBean data = asyncUpdateCartBean.getData();
                            AsyncUpdateCartBean.DataBean.CartPriceInfoBean cart_price_info = data.getCart_price_info();
                            tv_sumMoney.setText("¥ "+cart_price_info.getTotal_fee());
                        }
                    }
                });

    }


    public void  AsyncUpdateCart(ArrayList<CartsBean> cartList){
        LoadingDialogShow();
        String s = new GsonBuilder().create().toJson(cartList);
        OkGo.<String>post(RequstUrlUtils.URL.AsyncUpdateCart)
                .params("uid", uid)
                .params("token", token)
                .params("cart",s)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LoadingDialogClose();
                        AsyncUpdateCartBean asyncUpdateCartBean = new GsonBuilder().create().fromJson(response.body(), AsyncUpdateCartBean.class);
                        if (asyncUpdateCartBean.getCode() == 1) {
                            AsyncUpdateCartBean.DataBean data = asyncUpdateCartBean.getData();
                            AsyncUpdateCartBean.DataBean.CartPriceInfoBean cart_price_info = data.getCart_price_info();
                            InitData();
                            tv_sumMoney.setText("¥ " + cart_price_info.getTotal_fee());
                        }
                    }
                });
//        for (int a=0;a<cartList.size();a++) {
//            int finalA = a;
//            String cart = new GsonBuilder().create().toJson(cartList.get(a));
//            OkGo.<String>post(RequstUrlUtils.URL.AsyncUpdateCart)
//                    .params("uid", uid)
//                    .params("token", token)
//                    .params("cart", cart)
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onSuccess(Response<String> response) {
//                            AsyncUpdateCartBean asyncUpdateCartBean = new GsonBuilder().create().fromJson(response.body(), AsyncUpdateCartBean.class);
//                            if (asyncUpdateCartBean.getCode() == 1) {
//                                AsyncUpdateCartBean.DataBean data = asyncUpdateCartBean.getData();
//                                AsyncUpdateCartBean.DataBean.CartPriceInfoBean cart_price_info = data.getCart_price_info();
//                                if (finalA ==cartList.size()-1) {
//                                    InitData();
//                                    tv_sumMoney.setText("¥ " + cart_price_info.getTotal_fee());
//                                }
//                            }
//                        }
//                    });
//        }

    }



    /*立即购买*/
    public void OffHandPay(){
        OkGo.<String>post(RequstUrlUtils.URL.CartAdd2)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            Intent intent = new Intent(mContext, PlaceOrderActivity.class);
                            intent.putExtra("type","2");
                            intent.putExtra("content", response.body());
                            intent.putExtra("item_id", "");
                            startActivity(intent);
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }


    public  void LoadingDialogShow(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(getContext());
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingDialogClose(){
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){}
    }
}
