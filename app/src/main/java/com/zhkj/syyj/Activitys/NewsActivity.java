package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.R;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.news_img_back).setOnClickListener(this);
        findViewById(R.id.news_rl_system_message).setOnClickListener(this);
        findViewById(R.id.news_rl_services_message).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.news_img_back:
                finish();
                break;
            case R.id.news_rl_system_message:
                startActivity(new Intent(mContext,SystemMessageActivity.class));
                break;
            case R.id.news_rl_services_message:
                startActivity(new Intent(mContext,ServicesMessageActivity.class));
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
