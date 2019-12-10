package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;

public class MessageDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_time;
    private TextView tv_content;
    private String title;
    private String id;
    private String token;
    private String uid;
    private String content;
    private String time;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        time = intent.getStringExtra("time");
        content = intent.getStringExtra("content");
        InitUI();
        GetMessageData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        GetMessageData();
    }

    private void InitUI() {
        findViewById(R.id.message_detail_img_back).setOnClickListener(this);
        TextView tab_title= findViewById(R.id.message_detail_tab_title);
        tv_title = findViewById(R.id.message_detail_tv_title);
        tv_time = findViewById(R.id.message_detail_tv_time);
        tv_content = findViewById(R.id.message_detail_tv_content);
        tab_title.setText(title);
        //根据title不一样获取不同数据
        if (title.equals("系统消息详情")){

        }else if (title.equals("服务消息详情")){

        }
        tv_title.setText(name);
        tv_time.setText(time);
        tv_content.setText(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_detail_img_back:
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

    //获取用户信息
    public void GetMessageData(){
        OkGo.<String>get(RequstUrlUtils.URL.setMessageForRead)
                .params("uid",uid)
                .params("token",token)
                .params("rec_id",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }
}
