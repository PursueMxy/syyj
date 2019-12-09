package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.contract.EvaluateContract;
import com.zhkj.syyj.presenter.EvaluatePresenter;

import java.util.ArrayList;
import java.util.List;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener, EvaluateContract.View {

    private TextView tv_praise;
    private TextView tv_middle;
    private TextView tv_difference;
    private TextView tv_evaluate;
    private ListView evaluate_listview;
    private MyAdapter myAdapter;
    private String order_id;
    private List<OrderDetailBean.DataBean.OrderGoodsBean> order_goods=new ArrayList<>();
    private EvaluatePresenter evaluatePresenter;
    private String uid;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        InitUI();
        evaluatePresenter = new EvaluatePresenter(this);
        evaluatePresenter.GetOrderDetail(uid,token,order_id);
    }

    private void InitUI() {
        tv_praise = findViewById(R.id.evaluate_tv_praise);
        tv_middle = findViewById(R.id.evaluate_tv_middle);
        tv_difference = findViewById(R.id.evaluate_tv_difference);
        tv_evaluate = findViewById(R.id.evaluate_tv_evaluate);
        evaluate_listview = findViewById(R.id.evaluate_listview);
        findViewById(R.id.evaluate_img_back).setOnClickListener(this);
        myAdapter = new MyAdapter();
        evaluate_listview.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.evaluate_img_back:
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

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 3;
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
            View inflate = getLayoutInflater().inflate(R.layout.list_evaluate, null);
            return inflate;
        }
    }

    //数据解析
    public void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data){
        if (code==1){
            OrderDetailBean.DataBean.OrderStatusDetailBean order_status_detail = data.getOrder_status_detail();
            order_goods = data.getOrder_goods();
            myAdapter.notifyDataSetChanged();

        }
    }

}
