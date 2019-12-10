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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
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
    private Button btn_three;
    private Button btn_two;
    private Button btn_one;
    private RelativeLayout rl_bottom;
    private TextView tv_address;

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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        orderDetailPresenter.GetOrderDetail(uid,token,order_id);
    }

    private void InitUI() {
        noScrollListView = findViewById(R.id.order_detail_noScrollListView);
        findViewById(R.id.order_detail_rl_logistics).setOnClickListener(this);
        findViewById(R.id.order_detail_img_back).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_one).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_two).setOnClickListener(this);
        findViewById(R.id.order_detail_btn_three).setOnClickListener(this);
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
        tv_address = findViewById(R.id.order_detail_tv_address);
        rl_bottom = findViewById(R.id.order_detail_rl_bottom);
        btn_one = findViewById(R.id.order_detail_btn_one);
        btn_two = findViewById(R.id.order_detail_btn_two);
        btn_three = findViewById(R.id.order_detail_btn_three);
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
            case R.id.order_detail_btn_one:
                break;
            case R.id.order_detail_btn_two:
                String content= btn_two.getText().toString();
                if (content.equals("取消订单")){
                    orderDetailPresenter.GetCancelOrder(uid,token,order_id,"取消订单");
                }else if (content.equals("查看物流")){
                    Intent intent4 = new Intent(mContext, LogisticsDetailActivity.class);
                    intent4.putExtra("order_id",order_id);
                   startActivity(intent4);
                }else if (content.equals("再次购买")){
                    orderDetailPresenter.GetOrderOneMore(uid,token,order_id,"再次购买");
                }
                break;
            case R.id.order_detail_btn_three:
                String contents= btn_three.getText().toString();
                if (contents.equals("确认收货")){
                    orderDetailPresenter.GetConfirmOrder(uid,token,order_id,"确认收货");
                }else if (contents.equals("待评价")){
                    Intent intent4 = new Intent(mContext,EvaluateActivity.class);
                    intent4.putExtra("order_id",order_id);
                    startActivity(intent4);
                }else if (contents.equals("立即付款")){
                }else if (contents.equals("重新购买")){
                    orderDetailPresenter.GetOrderOneMore(uid,token,order_id,"重新购买");
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
            ImageView img= inflate.findViewById(R.id.list_goods_img);
            tv_title.setText(order_goods.get(position).getGoods_name());
            tv_sn.setText(order_goods.get(position).getSpec_key_name());
            tv_price.setText("¥"+order_goods.get(position).getGoods_price());
            tv_num.setText("x"+order_goods.get(position).getGoods_num());
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+order_goods.get(position).getOriginal_img()).into(img);
            return inflate;
        }
    }

    //数据解析
    public void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data){
        if (code==1){
            OrderDetailBean.DataBean.OrderStatusDetailBean order_status_detail = data.getOrder_status_detail();
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
            tv_expressTime.setText(DateUtils.timeStamp2Time2(data.getDelivery_doc().getShipping_time()+""));
            tv_logistics.setText(data.getDelivery_doc().getShipping_name());
            tv_address.setText(data.getFull_address());
            if (order_status_detail.getStatus()==0){
                rl_bottom.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
                btn_three.setVisibility(View.VISIBLE);
                btn_two.setVisibility(View.VISIBLE);
                btn_two.setText("取消订单");
                btn_three.setText("立即付款");
            }else if (order_status_detail.getStatus()==1){
                rl_bottom.setVisibility(View.GONE);
                btn_one.setVisibility(View.GONE);
                btn_three.setVisibility(View.GONE);
                btn_two.setVisibility(View.GONE);
            }else if (order_status_detail.getStatus()==2){
                rl_bottom.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
                btn_three.setVisibility(View.VISIBLE);
                btn_two.setVisibility(View.VISIBLE);
                btn_two.setText("查看物流");
                btn_three.setText("确认收货");
            }else if (order_status_detail.getStatus()==3){
                rl_bottom.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
                btn_three.setVisibility(View.VISIBLE);
                btn_two.setVisibility(View.VISIBLE);
                btn_two.setText("再次购买");
                btn_three.setText("待评价");
            }else if (order_status_detail.getStatus()==4){
                rl_bottom.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
                btn_two.setVisibility(View.GONE);
                btn_three.setVisibility(View.VISIBLE);
                btn_three.setText("重新购买");

            }else if (order_status_detail.getStatus()>4){
                rl_bottom.setVisibility(View.VISIBLE);
                btn_one.setVisibility(View.GONE);
                btn_three.setVisibility(View.GONE);
                btn_two.setVisibility(View.VISIBLE);
                btn_two.setText("再次购买");
                if (order_status_detail.getStatus()==5) {
                    btn_three.setVisibility(View.VISIBLE);
                    btn_three.setText("已评价");
                }
            }

        }
    }

    //点击返回
    public void UpdateUI(int code, String msg,String typename){
        ToastUtils.showToast(mContext,msg);
    }
}
