package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.BuyIntegralGoodsBean;
import com.zhkj.syyj.Beans.IntegraPayBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.PlaceOrderIntegralContract;
import com.zhkj.syyj.presenter.PlaceOrderIntegralPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceOrderIntegralActivity extends AppCompatActivity implements PlaceOrderIntegralContract.View {

    private Context mContext;
    private TextView tv_couponNumber;
    private TextView tv_freight;
    private TextView tv_contracts;
    private TextView tv_address;
    private String address_id;
    private PlaceOrderIntegralPresenter placeOrderIntegralPresenter;
    private String uid;
    private String token;
    private String content;
    private String item_id;
    @BindView(R.id.place_order_integral_tv_title)
    TextView tv_title;
    @BindView(R.id.place_order_integral_img)
    ImageView img_goods;
    @BindView(R.id.place_order_integral_tv_num)
    TextView tv_num;
    @BindView(R.id.place_order_integral_tv_sn)
    TextView tv_sn;
    @BindView(R.id.place_order_integral_tv_price)
    TextView tv_price;
    @BindView(R.id.place_order_integral_edt_message)
    EditText edt_message;
    private int goods_id;
    private String goods_num;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_integral);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        item_id = intent.getStringExtra("item_id");
        ButterKnife.bind(this);
        InitUI();
        InitData();
        placeOrderIntegralPresenter = new PlaceOrderIntegralPresenter(this);
        LoadingDialog();
        placeOrderIntegralPresenter.getDefaultAddress(uid,token);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        placeOrderIntegralPresenter.getDefaultAddress(uid,token);
    }

    private void InitData() {
        BuyIntegralGoodsBean buyIntegralGoodsBean = new GsonBuilder().create().fromJson(content, BuyIntegralGoodsBean.class);
        BuyIntegralGoodsBean.DataBean data = buyIntegralGoodsBean.getData();
        goods_id = data.getGoods_id();
        goods_num = data.getGoods_num();
        tv_sn.setText(data.getKey_name());
        tv_title.setText(data.getGoods_name());
        tv_price.setText(data.getExchange_integral()+"");
        tv_num.setText(data.getGoods_num());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(img_goods);
        tv_couponNumber.setText(""+data.getTotale());
        tv_freight.setText("¥ "+data.getShipping_price());
    }

    private void InitUI() {
        tv_address = findViewById(R.id.place_order_integral_tv_address);
        tv_contracts = findViewById(R.id.place_order_integral_tv_contracts);
        tv_couponNumber = findViewById(R.id.place_order_integral_tv_couponNumber);
        tv_freight = findViewById(R.id.place_order_integral_tv_freight);
    }

    @OnClick({R.id.place_order_integral_img_back,R.id.place_order_integral_btn_immediate_payment})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.place_order_integral_img_back:
                finish();
                break;
            case R.id.place_order_integral_btn_immediate_payment:
                String message = edt_message.getText().toString();
                placeOrderIntegralPresenter.GetIntegral(uid,token,goods_id+"",item_id,goods_num,address_id,message);
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

    //默认地址解析
    public void Update(int code, String msg, AddressBean.DataBean data){
        LoadingClose();
        if (code==1){
            address_id = data.getAddress_id()+"";
            tv_address.setText(data.getProvince()+data.getCity()+data.getDistrict()+data.getTwon()+data.getAddress());
            tv_contracts.setText(data.getConsignee()+"  "+data.getMobile());
        }
    }

    public void UpdateUI(int code, String msg, IntegraPayBean.DataBean data){
       if (code==1){
           Intent intent = new Intent(mContext, MyExchangeActivity.class);
           intent.putExtra("type","WAITSEND");
           startActivity(intent);
       }else {
           ToastUtils.showToast(mContext,msg);
       }
    }

    public void LoadingDialog(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(this);
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingClose(){
        try {
            if (progressDialog != null){
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){

        }
    }
}
