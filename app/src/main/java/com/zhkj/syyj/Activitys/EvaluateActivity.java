package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.R;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_praise;
    private TextView tv_middle;
    private TextView tv_difference;
    private TextView tv_evaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        InitUI();
    }

    private void InitUI() {
        tv_praise = findViewById(R.id.evaluate_tv_praise);
        tv_middle = findViewById(R.id.evaluate_tv_middle);
        tv_difference = findViewById(R.id.evaluate_tv_difference);
        tv_evaluate = findViewById(R.id.evaluate_tv_evaluate);
        findViewById(R.id.evaluate_img_back).setOnClickListener(this);
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
}
