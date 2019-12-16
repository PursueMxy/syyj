package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.CallCenterAdapter;
import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;

public class CallCenterActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView mRvChat;
    private List<String> list=new ArrayList<>();
    private Context mContext;
    private CallCenterAdapter callCenterAdapter;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_center);
        mContext = getApplicationContext();
        InitUI();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void InitUI() {
        findViewById(R.id.callCenter_img_back).setOnClickListener(this);
        mSwipeRefresh = findViewById(R.id.swipe_chat);
        mRvChat = findViewById(R.id.rv_chat_list);
        callCenterAdapter = new CallCenterAdapter(mContext,list);
        LinearLayoutManager mLinearLayout=new LinearLayoutManager(this);
        mRvChat.setLayoutManager(mLinearLayout);
        mRvChat.setAdapter(callCenterAdapter);
        mSwipeRefresh.setOnRefreshListener(this);
        tv_content = findViewById(R.id.call_center_tv_content);
        findViewById(R.id.call_center_img_sendout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.callCenter_img_back:
                finish();
                break;
            case R.id.call_center_img_sendout:
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
    public void onRefresh() {
        list.addAll(0,list);
        callCenterAdapter.notifyDataSetChanged();
        mSwipeRefresh.setRefreshing(false);
    }
}
