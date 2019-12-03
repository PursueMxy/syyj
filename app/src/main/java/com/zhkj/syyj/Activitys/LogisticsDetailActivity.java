package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhkj.syyj.R;

public class LogisticsDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list_view;
    private Context mContext;
    private MyAdapter myAdapter;
    private TextView tv_delivery_express;
    private TextView tv_goodsNum;
    private TextView tv_expressNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_detail);
        mContext = getApplicationContext();
        InitUI();
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
            return 5;
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
            return inflate;
        }
    }
}
