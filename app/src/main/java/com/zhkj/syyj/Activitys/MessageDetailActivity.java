package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;

public class MessageDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_time;
    private TextView tv_content;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        InitUI();
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
}
