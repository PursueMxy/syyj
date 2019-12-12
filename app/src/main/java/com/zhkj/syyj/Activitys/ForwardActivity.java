package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.ForwardAdapter;
import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.SDFileHelper;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForwardActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private Context mContext;
    private GridLayoutManager mLayoutManager;
    private ForwardAdapter forwardAdapter;
    private TextView tv_content;
    private ArrayList<String> share_imgs;
    private String content;
    private String task_id;
    private SDFileHelper sdFileHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        task_id = intent.getStringExtra("task_id");
        content = intent.getStringExtra("content");
        share_imgs = intent.getStringArrayListExtra("share_imgs");
        InitUI();
        sdFileHelper = new SDFileHelper(this);

    }

    private void InitData() {
        for(int a=0;a<share_imgs.size();a++){
            sdFileHelper.savePicture( RequstUrlUtils.URL.HOST +share_imgs);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void InitUI() {
        findViewById(R.id.forward_btn_define).setOnClickListener(this);
        findViewById(R.id.forward_img_back).setOnClickListener(this);
        tv_content = findViewById(R.id.forward_tv_content);
        mRecyclerView = findViewById(R.id.forward_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager =new GridLayoutManager(mContext, 3);
        forwardAdapter = new ForwardAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setEnabledScroll(false);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_5)));
            }
        });
        forwardAdapter.setListAll(share_imgs);
        mRecyclerView.setAdapter(forwardAdapter);
        tv_content.setText(content);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forward_img_back:
                finish();
                break;
            case R.id.forward_btn_define:
                InitData();
                WechatDialog();
                break;
                default:
                    break;
        }
    }

    //转发微信弹出窗
    public void  WechatDialog(){
        final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_forward, null);
        inflate.findViewById(R.id.dialog_forward_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }
}
