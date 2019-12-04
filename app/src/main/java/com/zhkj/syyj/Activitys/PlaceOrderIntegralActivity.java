package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceOrderIntegralActivity extends AppCompatActivity {

    @BindView(R.id.place_order_integral_noScrollListView)
    NoScrollListView noScrollListView;
    private Context mContext;
    private MyAdapter myAdapter;
    private TextView tv_couponNumber;
    private TextView tv_freight;
    private TextView tv_contracts;
    private TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order_integral);
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        InitUI();
    }

    private void InitUI() {
        myAdapter = new MyAdapter();
        noScrollListView.setAdapter(myAdapter);
        tv_address = findViewById(R.id.place_order_integral_tv_address);
        tv_contracts = findViewById(R.id.place_order_integral_tv_contracts);
        tv_couponNumber = findViewById(R.id.place_order_integral_tv_couponNumber);
        tv_freight = findViewById(R.id.place_order_integral_tv_freight);
    }

    @OnClick({R.id.place_order_integral_img_back})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.place_order_integral_img_back:
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_goods, null);
            return inflate;
        }
    }
}
