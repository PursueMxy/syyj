package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.PlaceOrderBean;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.PlaceOrderContract;
import com.zhkj.syyj.presenter.PlaceOrderPresenter;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener, PlaceOrderContract.View {

    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;
    private Context mContext;
    private TextView tv_price;
    private TextView tv_freight;
    private TextView tv_coupon;
    private TextView tv_contacts;
    private TextView tv_address;
    private CheckBox cb_aliPay;
    private CheckBox cb_wechatPay;
    private CheckBox cb_balancePay;
    private String content;
    private List<PlaceOrderBean.DataBean.CartListBean> cartList=new ArrayList<>();
    private PlaceOrderBean.DataBean.CartPriceInfoBean cartPriceInfo;
    private TextView tv_message;
    private String uid;
    private String token;
    private PlaceOrderPresenter placeOrderPresenter;
    private String address_id;
    private String item_id;
    private String pay_type="user_money";
    private int ADDRESS_CODE=2001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        item_id = intent.getStringExtra("item_id");
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        placeOrderPresenter = new PlaceOrderPresenter(this);
        InitUI();
        InitData();
    }

    private void InitData() {
        placeOrderPresenter.getDefaultAddress(uid,token);
        Log.e("content",content);
        PlaceOrderBean placeOrderBean = new GsonBuilder().create().fromJson(content, PlaceOrderBean.class);
        PlaceOrderBean.DataBean data = placeOrderBean.getData();
        cartList = data.getCartList();
        cartPriceInfo = data.getCartPriceInfo();
        myAdapter.notifyDataSetChanged();
        tv_price.setText("¥ "+cartPriceInfo.getTotal_fee());
        tv_freight.setText("¥ "+cartPriceInfo.getShipping_fee());
    }

    private void InitUI() {
        findViewById(R.id.place_order_img_back).setOnClickListener(this);
        findViewById(R.id.place_order_rl_address).setOnClickListener(this);
        findViewById(R.id.place_order_btn_immediate_payment).setOnClickListener(this);
        noScrollListView = findViewById(R.id.place_order_noScrollListView);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
        tv_address = findViewById(R.id.place_order_tv_address);
        tv_contacts = findViewById(R.id.place_order_tv_contacts);
        tv_coupon = findViewById(R.id.place_order_tv_coupon);
        tv_freight = findViewById(R.id.place_order_tv_freight);
        tv_message = findViewById(R.id.place_order_tv_message);
        tv_price = findViewById(R.id.place_order_tv_price);
        cb_aliPay = findViewById(R.id.place_order_cb_aliPay);
        cb_wechatPay = findViewById(R.id.place_order_cb_wechatPay);
        cb_balancePay = findViewById(R.id.place_order_cb_balancePay);
        cb_aliPay.setOnClickListener(this);
        cb_balancePay.setOnClickListener(this);
        cb_wechatPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.place_order_img_back:
                finish();
                break;
            case R.id.place_order_btn_immediate_payment:
                String message = tv_message.getText().toString();
                int goods_id = cartList.get(0).getGoods_id();
                int goods_num = cartList.get(0).getGoods_num();
                placeOrderPresenter.GetCarPay(uid,token,address_id+"","",message,goods_id+"",goods_num+"",item_id,
                        "buy_now",pay_type);
                break;
            case R.id.place_order_cb_balancePay:
                if(cb_balancePay.isChecked()){
                 cb_balancePay.setChecked(true);
                 cb_aliPay.setChecked(false);
                 cb_wechatPay.setChecked(false);
                }else {
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(true);
                    cb_wechatPay.setChecked(false);
                }
                pay_type="user_money";
                break;
            case R.id.place_order_cb_aliPay:
                if(cb_aliPay.isChecked()){
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(true);
                    cb_wechatPay.setChecked(false);
                }else {
                    cb_balancePay.setChecked(true);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(false);
                }
                pay_type="alipay";
                break;
            case R.id.place_order_cb_wechatPay:
                if(cb_wechatPay.isChecked()){
                    cb_balancePay.setChecked(false);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(true);
                }else {
                    cb_balancePay.setChecked(true);
                    cb_aliPay.setChecked(false);
                    cb_wechatPay.setChecked(false);
                }
                pay_type="weixin";
                break;
            case R.id.place_order_rl_address:
                Intent intent = new Intent(mContext,ShoppingAddressActivity.class);
                intent.putExtra("type","select");
                startActivityForResult(intent,ADDRESS_CODE);
                break;
                default:
                    break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return cartList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_goods, null);
            TextView tv_title = inflate.findViewById(R.id.list_goods_tv_title);
            TextView tv_sn = inflate.findViewById(R.id.list_goods_tv_sn);
            TextView tv_price = inflate.findViewById(R.id.list_goods_tv_price);
            TextView tv_num = inflate.findViewById(R.id.list_goods_tv_num);
            ImageView goods_img = inflate.findViewById(R.id.list_goods_img);
            tv_title.setText(cartList.get(position).getGoods_name());
            tv_sn.setText(cartList.get(position).getSpec_key_name());
            tv_price.setText("¥"+cartList.get(position).getGoods_price());
            tv_num.setText("x"+cartList.get(position).getGoods_num());
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+cartList.get(position).getOriginal_img()).into(goods_img);
            return inflate;
        }
    }

    //默认地址解析
    public void Update(int code, String msg, AddressBean.DataBean data){
        if (code==1){
            address_id = data.getAddress_id()+"";
            tv_address.setText(data.getProvince()+data.getCity()+data.getDistrict()+data.getTwon()+data.getAddress());
            tv_contacts.setText(data.getConsignee()+"  "+data.getMobile());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDRESS_CODE&&resultCode==ADDRESS_CODE) {
            address_id = data.getStringExtra("address_id");
            String address = data.getStringExtra("address");
            String contacts= data.getStringExtra("contacts");
            tv_address.setText(address);
            tv_contacts.setText(contacts);
        }
    }

    //订单支付返回
    public void  UpdateUI(int code,String msg){
        if (code==1){
            Intent intent = new Intent(mContext, MyOrderActivity.class);
            intent.putExtra("title","待发货");
            startActivity(intent);
            finish();
        }
        ToastUtils.showToast(mContext,msg);

    }
}
