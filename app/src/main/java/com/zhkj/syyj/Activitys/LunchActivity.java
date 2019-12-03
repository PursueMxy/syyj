package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zhkj.syyj.MainActivity;
import com.zhkj.syyj.R;

public class LunchActivity extends AppCompatActivity {

    private Context mContext;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(mContext,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        mContext = getApplicationContext();
        handler.postDelayed(runnable,3000);
        InitUI();
    }

    private void InitUI() {
    }
}

