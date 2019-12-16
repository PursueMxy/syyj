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
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Beans.ExpressBean;
import com.zhkj.syyj.Beans.LogistisBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;

import java.util.ArrayList;
import java.util.List;

public class LogisticsDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list_view;
    private Context mContext;
    private MyAdapter myAdapter;
    private TextView tv_delivery_express;
    private TextView tv_goodsNum;
    private TextView tv_expressNumber;
    private String order_id;
    private String uid;
    private String token;
    private List<LogistisBean.DataBean> dataList=new ArrayList<>();
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_detail);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        mContext = getApplicationContext();
        InitUI();
        GetLogistics();
    }

    private void InitUI() {
        findViewById(R.id.logistics_detail_img_back).setOnClickListener(this);
        list_view = findViewById(R.id.logistics_detail_list);
        myAdapter = new MyAdapter();
        list_view.setAdapter(myAdapter);
        tv_delivery_express = findViewById(R.id.logistics_tv_delivery_express);
        tv_goodsNum = findViewById(R.id.logistics_tv_goodsNum);
        tv_expressNumber = findViewById(R.id.logistics_tv_expressNumber);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logistics_detail_img_back:
                finish();
                break;
        }
    }

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return dataList.size();
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_logistics_detail, null);
            TextView tv_connect = inflate.findViewById(R.id.list_logistics_tv_connect);
            TextView tv_time = inflate.findViewById(R.id.list_logistics_tv_time);
            tv_connect.setText(dataList.get(position).getContext());
            tv_time.setText(dataList.get(position).getTime());
            return inflate;
        }
    }

    //获取物流信息
    public void GetLogistics(){
        LoadingDialog();
        OkGo.<String>get(RequstUrlUtils.URL.OrderExpress)
                .params("uid",uid)
                .params("token",token)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LoadingClose();
                        ExpressBean expressBean = new GsonBuilder().create().fromJson(response.body(), ExpressBean.class);
                        if (expressBean.getCode()==1){
                            ExpressBean.DataBean data = expressBean.getData();
                            String invoice_no = data.getInvoice_no();
                            String shipping_code = data.getShipping_code();
                            GetQueryExpress(invoice_no,shipping_code);
                            tv_delivery_express.setText("配送快递："+data.getShipping_name());
                            tv_expressNumber.setText("快递单号："+data.getInvoice_no());
                            tv_goodsNum.setText("共"+ data.getGoods_num() +"件商品");
                        }
                    }
                });

    }

    //查找物流
    public void GetQueryExpress(String invoice_no,String shipping_code){
        OkGo.<String>get(RequstUrlUtils.URL.QueryExpress)
                .params("shipping_code",shipping_code)
                .params("invoice_no",invoice_no)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            LogistisBean logistisBean = new GsonBuilder().create().fromJson(response.body(), LogistisBean.class);
                            if (logistisBean.getCode()==1){
                                dataList = logistisBean.getData();
                                myAdapter.notifyDataSetChanged();
                            }
                        }catch (Exception e){

                        }
                    }
                });
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
