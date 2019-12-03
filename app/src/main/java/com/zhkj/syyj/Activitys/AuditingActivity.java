package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.R;

public class AuditingActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditing);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        findViewById(R.id.auditing_img_back).setOnClickListener(this);
        findViewById(R.id.auditing_btn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.auditing_img_back:
                finish();
                break;
            case R.id.auditing_btn_back:
                startActivity(new Intent(mContext,LoginActivity.class));
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
