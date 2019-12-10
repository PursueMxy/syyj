package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.MyOrderAdapter;
import com.zhkj.syyj.Beans.OrderListBean;
import com.zhkj.syyj.Beans.ShoppingCarDataBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.contract.OrderTypeContract;
import com.zhkj.syyj.presenter.OrderTypePresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderTypeActivity extends AppCompatActivity implements View.OnClickListener, OrderTypeContract.View {

    private TextView tv_title;
    private ExpandableListView order_type_elv;
    private List<OrderListBean.DataBean> datas=new ArrayList<>();
    private Context mContext;
    private MyOrderAdapter myOrderAdapter;
    private ImageView ivNoContant;
    private RelativeLayout rlNoContant;
    private String titleName;
    private OrderTypePresenter orderTypePresenter;
    private String uid;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_type);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        orderTypePresenter = new OrderTypePresenter(this);
        Intent intent = getIntent();
        titleName = intent.getStringExtra("title");
       if (titleName.equals("待付款")){
            orderTypePresenter.GetOrderType(uid, token, "WAITPAY", 0, 0);
        }else if (titleName.equals("待发货")) {
           orderTypePresenter.GetOrderType(uid, token, "WAITSEND", 0, 0);
       } else if (titleName.equals("待收货")){
            orderTypePresenter.GetOrderType(uid, token, "WAITRECEIVE", 0, 0);
        }else if (titleName.equals("已完成")){
            orderTypePresenter.GetOrderType(uid, token, "FINISH", 0, 0);
        }else {
            orderTypePresenter.GetOrderType(uid, token, "", 0, 0);
        }
        InitUI();
        initExpandableListView();
        initData();
    }

    private void InitUI() {
        tv_title = findViewById(R.id.order_type_tv_title);
        tv_title.setText(titleName);
        ivNoContant = findViewById(R.id.order_type_img_no_contant);
        rlNoContant = findViewById(R.id.order_type_no_contant);
        findViewById(R.id.order_type_img_back).setOnClickListener(this);
        order_type_elv = findViewById(R.id.order_type_elv);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        initExpandableListViewData(datas);
    }

    /**
     * 初始化ExpandableListView
     * 创建数据适配器adapter，并进行初始化操作
     */
    private void initExpandableListView() {
        myOrderAdapter = new MyOrderAdapter(mContext);
        order_type_elv.setAdapter(myOrderAdapter);
        order_type_elv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("点击事件",position+"加"+id);
//                startActivity(new Intent(mContext,OrderDetailActivity.class));
            }
        });
    }

    /**
     * 初始化ExpandableListView的数据
     * 并在数据刷新时，页面保持当前位置
     *
     * @param datas 购物车的数据
     */
    private void initExpandableListViewData(List<OrderListBean.DataBean> datas) {
        Log.e("datas",datas.size()+"");
        if (datas != null && datas.size() > 0) {
            //刷新数据时，保持当前位置
            myOrderAdapter.setData(datas);
            //使所有组展开
            for (int i = 0; i < myOrderAdapter.getGroupCount(); i++) {
                order_type_elv.expandGroup(i);
            }

            //使组点击无效果（true）
            order_type_elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
//                    Log.e("点击事件",groupPosition+"加"+id);
                    return true;
                }
            });

            rlNoContant.setVisibility(View.GONE);
            order_type_elv.setVisibility(View.VISIBLE);
        } else {
            rlNoContant.setVisibility(View.VISIBLE);
            order_type_elv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_type_img_back:
                finish();
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

    //解析数据
    public void UpdateJson(int code,String msg,String data){
        if (code==1) {
            try {
                OrderListBean orderListBean = new GsonBuilder().create().fromJson(data, OrderListBean.class);
                datas= orderListBean.getData();
                initExpandableListViewData(datas);
            }catch (Exception e){
                initExpandableListViewData(datas);
            }
        }
    }
}
