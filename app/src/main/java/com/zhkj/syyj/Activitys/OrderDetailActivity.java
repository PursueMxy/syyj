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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.contract.OrderDetailContract;
import com.zhkj.syyj.presenter.OrderDetailPresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener, OrderDetailContract.View {

    private Context mContext;
    private NoScrollListView noScrollListView;
    private MyAdapter myAdapter;
    private TextView tv_confirmTime;
    private TextView tv_coupon;
    private TextView tv_expressTime;
    private TextView tv_freight;
    private TextView tv_logistics;
    private TextView tv_orderNumber;
    private TextView tv_payType;
    private TextView tv_type;
    private OrderDetailPresenter orderDetailPresenter;
    private String uid;
    private String token;
    private String order_id;
    private List<OrderDetailBean.DataBean.OrderGoodsBean> order_goods=new ArrayList<>();
    private TextView tv_consignee;
    private TextView tv_goodsPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        orderDetailPresenter = new OrderDetailPresenter(this);
        InitUI();
        orderDetailPresenter.GetOrderDetail(uid,token,order_id);
    }

    private void InitUI() {
        noScrollListView = findViewById(R.id.order_detail_noScrollListView);
        findViewById(R.id.order_detail_rl_logistics).setOnClickListener(this);
        findViewById(R.id.order_detail_img_back).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_immediate_payment).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_checkExpress).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_backOrder).setOnClickListener(this);
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
        tv_confirmTime = findViewById(R.id.order_detail_tv_confirmTime);
        tv_coupon = findViewById(R.id.order_detail_tv_coupon);
        tv_expressTime = findViewById(R.id.order_detail_tv_expressTime);
        tv_freight = findViewById(R.id.order_detail_tv_freight);
        tv_logistics = findViewById(R.id.order_detail_tv_logistics);
        tv_orderNumber = findViewById(R.id.order_detail_tv_orderNumber);
        tv_payType = findViewById(R.id.order_detail_tv_payType);
        tv_type = findViewById(R.id.order_detail_tv_type);
        tv_consignee = findViewById(R.id.order_detail_tv_consignee);
        tv_goodsPrice = findViewById(R.id.order_detail_tv_goodsPrice);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_detail_rl_logistics:
                Intent intent = new Intent(mContext, LogisticsDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.order_detail_img_back:
                finish();
                break;
            case R.id.order_detail_btn_checkExpress:
                break;
            case R.id.order_detail_btn_backOrder:
                break;
            case R.id.order_detail_btn_immediate_payment:
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
            return order_goods.size();
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
            tv_title.setText(order_goods.get(position).getGoods_name());
            tv_sn.setText(order_goods.get(position).getSpec_key_name());
            tv_price.setText("¥"+order_goods.get(position).getGoods_price());
            tv_num.setText("x"+order_goods.get(position).getGoods_num());
            return inflate;
        }
    }

    //数据解析
    public void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data){
        if (code==1){
            order_goods = data.getOrder_goods();
            myAdapter.notifyDataSetChanged();
            tv_type.setText(data.getOrder_status_detail().getName());
            tv_freight.setText(data.getShipping_price());
            tv_coupon.setText(data.getCoupon_price());
            tv_orderNumber.setText(data.getOrder_sn());
            tv_confirmTime.setText(DateUtils.timeStamp2Time2(data.getAdd_time()+""));
            tv_payType.setText(data.getPay_name());
            tv_goodsPrice.setText("¥ "+data.getGoods_price());
            tv_consignee.setText(data.getConsignee()+" "+data.getMobile());
        }
    }
}
