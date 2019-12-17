package com.zhkj.syyj.Activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhkj.syyj.Beans.AddressBean;
import com.zhkj.syyj.Beans.AlipayBean;
import com.zhkj.syyj.Beans.AuthResult;
import com.zhkj.syyj.Beans.PayResult;
import com.zhkj.syyj.Beans.PlaceOrderBean;
import com.zhkj.syyj.Beans.WechatPayBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.AppContUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.PlaceOrderContract;
import com.zhkj.syyj.presenter.PlaceOrderPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private int COUPON_CODE=2002;
    private String type;
    private String action="";
    private List<PlaceOrderBean.DataBean.UserCartCouponListBean> userCartCouponList=new ArrayList<>();
    private String  cid="";
    private double coupon_money;
    private float money;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private SharedPreferences share;
    private CustomProgressDialog progressDialog;
    private TextView tv_default;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        item_id = intent.getStringExtra("item_id");
        type = intent.getStringExtra("type");
        if (type.equals("1")){
            action="buy_now";
        }else if (type.equals("2")){
            action="";
            item_id="";
        }
        mContext = getApplicationContext();
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        placeOrderPresenter = new PlaceOrderPresenter(this);
        InitUI();
        InitData();
    }

    private void InitData() {
        LoadingDialog();
        placeOrderPresenter.getDefaultAddress(uid,token);
        PlaceOrderBean placeOrderBean = new GsonBuilder().create().fromJson(content, PlaceOrderBean.class);
        PlaceOrderBean.DataBean data = placeOrderBean.getData();
        userCartCouponList = data.getUserCartCouponList();
        cartList = data.getCartList();
        cartPriceInfo = data.getCartPriceInfo();
        myAdapter.notifyDataSetChanged();
        if (userCartCouponList.size()>0){
            tv_coupon.setText(userCartCouponList.get(0).getCoupon().getName());
            cid = userCartCouponList.get(0).getId()+"";
            coupon_money = Double.parseDouble(userCartCouponList.get(0).getCoupon().getMoney());
        }else {
            tv_coupon.setText("没有可以用优惠券");
        }
        tv_freight.setText("¥ "+cartPriceInfo.getShipping_fee());
        money=(float) (cartPriceInfo.getTotal_fee()-coupon_money);
        tv_price.setText("¥ "+ money);
    }

    private void InitUI() {
        findViewById(R.id.place_order_img_back).setOnClickListener(this);
        findViewById(R.id.place_order_rl_address).setOnClickListener(this);
        findViewById(R.id.place_order_btn_immediate_payment).setOnClickListener(this);
        noScrollListView = findViewById(R.id.place_order_noScrollListView);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
        tv_address = findViewById(R.id.place_order_tv_address);
        tv_default = findViewById(R.id.place_order_tv_default);
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
        tv_coupon.setOnClickListener(this);
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
                placeOrderPresenter.GetCarPay(uid,token,address_id+"",cid,message,goods_id+"",goods_num+"",item_id,
                        action,pay_type);
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
            case R.id.place_order_tv_coupon:
                if (userCartCouponList.size()>0){
                    Intent intent1 = new Intent(mContext, UsableCouponActivity.class);
                    intent1.putExtra("coupon",content);
                    startActivityForResult(intent1,COUPON_CODE);
                }
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
        LoadingClose();
        if (data!=null) {
            if (code == 1) {
                address_id = data.getAddress_id() + "";
                tv_address.setText(data.getProvince() + data.getCity() + data.getDistrict() + data.getTwon() + data.getAddress());
                tv_contacts.setText(data.getConsignee() + "  " + data.getMobile());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDRESS_CODE&&resultCode==ADDRESS_CODE) {
            address_id = data.getStringExtra("address_id");
            String address = data.getStringExtra("address");
            String contacts= data.getStringExtra("contacts");
            String IsDefault = data.getStringExtra("default");
            if (IsDefault.equals("1")){
                tv_default.setVisibility(View.VISIBLE);
            }else {
                tv_default.setVisibility(View.GONE);
            }
            tv_address.setText(address);
            tv_contacts.setText(contacts);
        }else  if (requestCode == COUPON_CODE&&resultCode==COUPON_CODE) {
            cid= data.getStringExtra("cid");
            String name = data.getStringExtra("name");
            tv_coupon.setText(name);
            double coupon_money = Double.parseDouble(data.getStringExtra("coupon_money"));
            money=(float) (cartPriceInfo.getTotal_fee()- coupon_money);
            tv_price.setText("¥ "+money);
        }
    }

    //订单支付返回
    public void  UpdateUI(int code,String msg,String content){
        if (code==1){
            if (pay_type.equals("weixin")){
                SharedPreferences.Editor editor = share.edit();
                editor.putString("pay_type","order");
                editor.commit();//提交
                WechatPayBean wechatPayBean = new GsonBuilder().create().fromJson(content, WechatPayBean.class);
                WechatPayBean.DataBean data = wechatPayBean.getData();
                WechatPayBean.DataBean.PayInfoBean payInfo = data.getPayInfo();
                IWXAPI wxapi = WXAPIFactory.createWXAPI(mContext, AppContUtils.WX_APP_ID, true);
                // 将该app注册到微信
                wxapi.registerApp(AppContUtils.WX_APP_ID);
                if (!wxapi.isWXAppInstalled()) {
                    ToastUtils.showToast(mContext,"你没有安装微信");
                    return;
                }
                try {
                    //我们把请求到的参数全部给微信
                    PayReq req = new PayReq(); //调起微信APP的对象
                    req.appId = payInfo.getAppid();
                    req.partnerId =payInfo.getPartnerid();
                    req.prepayId = payInfo.getPrepayid();
                    req.nonceStr = payInfo.getNoncestr();
                    req.timeStamp = payInfo.getTimestamp()+"";
                    req.packageValue =payInfo.getPackageX(); //Sign=WXPay
                    req.sign =payInfo.getSign();
                    wxapi.sendReq(req);//发送调起微信的请求
                }catch (Exception e){
                    ToastUtils.showToast(mContext,e.getMessage().toString());
                }

            }else if (pay_type.equals("alipay")){
                AlipayBean alipayBean = new GsonBuilder().create().fromJson(content, AlipayBean.class);
                AlipayBean.DataBean data = alipayBean.getData();
                String orderInfo = data.getPayInfo();
                final Runnable payRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PlaceOrderActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        Log.i("msp", result.toString());
                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                // 必须异步调用
                Thread payThread = new Thread(payRunnable);
                payThread.start();

            }else if (pay_type.equals("user_money")){

                Intent intent = new Intent(mContext, MyOrderActivity.class);
                intent.putExtra("title","待发货");
                startActivity(intent);
                finish();
            }
        }else {
            ToastUtils.showToast(mContext, msg);
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    Log.e("支付宝支付","调用成功");
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showToast(mContext,"支付成功");
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Intent intent = new Intent(mContext, PlaceOrderActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        ToastUtils.showToast(mContext,"支付失败");
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        showAlert(PlaceOrderActivity.this, getString(R.string.auth_success) + authResult);
                    } else {
                        // 其他状态值则为授权失败
                        showAlert(PlaceOrderActivity.this, getString(R.string.auth_failed) + authResult);
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };

    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener onDismiss) {
        new AlertDialog.Builder(ctx)
                .setMessage(info)
                .setPositiveButton(R.string.confirm, null)
                .setOnDismissListener(onDismiss)
                .show();
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
