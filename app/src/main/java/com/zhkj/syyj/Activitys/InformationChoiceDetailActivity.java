package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Beans.NewsDetailBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.contract.InformationChoiceDetailContract;
import com.zhkj.syyj.presenter.InformationChoiceDetailPresenter;
import com.zhkj.syyj.presenter.InformationChoicePresenter;


public class InformationChoiceDetailActivity extends AppCompatActivity implements View.OnClickListener, InformationChoiceDetailContract.View {

    private TextView tv_title;
    private InformationChoiceDetailPresenter informationChoiceDetailPresenter;
    private String id;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_choice_detail);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        InitUI();
        informationChoiceDetailPresenter = new InformationChoiceDetailPresenter(this);
        LoadingDialog();
        informationChoiceDetailPresenter.getNewsDetail(id);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        informationChoiceDetailPresenter.getNewsDetail(id);
    }

    private void InitUI() {
        findViewById(R.id.information_choice_detail_img_back).setOnClickListener(this);
        tv_title = findViewById(R.id.information_choice_detail_tv_title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information_choice_detail_img_back:
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

    //获取到内容
    public void UpdateNewsDetail(NewsDetailBean newsDetailBean){
        LoadingClose();
        int code = newsDetailBean.getCode();
        if (code==1){
            NewsDetailBean.DataBean data = newsDetailBean.getData();
            tv_title.setText(Html.fromHtml(data.getContent()));
        }
    }
    public void LoadingDialog(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(this);
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingClose(){
        try {
            if (progressDialog != null){
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){

        }
    }

}

