package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.ServicesMessageAdapter;
import com.zhkj.syyj.Beans.MessageNoticeBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.contract.ServicesMessageContract;
import com.zhkj.syyj.presenter.ServicesMessagePresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class ServicesMessageActivity extends AppCompatActivity implements View.OnClickListener, ServicesMessageContract.View {

    private XRecyclerView mRecyclerView;
    private List<MessageNoticeBean.DataBean> list=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private ServicesMessageAdapter servicesMessageAdapter;
    private String token;
    private String uid;
    private int page=1;
    private ServicesMessagePresenter servicesMessagePresenter;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_message);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        servicesMessagePresenter = new ServicesMessagePresenter(this);
        LoadingDialog();
        servicesMessagePresenter.GetMessageNoticeList(uid,token,1,page);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        servicesMessagePresenter.GetMessageNoticeList(uid,token,1,page);
    }

    private void InitUI() {
        findViewById(R.id.services_message_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.services_message_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        servicesMessageAdapter = new ServicesMessageAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                servicesMessagePresenter.GetMessageNoticeList(uid,token,1,page);
            }

            @Override
            public void onLoadMore() {
                //加载更多
                page=page+1;
                servicesMessagePresenter.GetMessageNoticeList(uid,token,1,page);
            }
        });
        mRecyclerView.setAdapter( servicesMessageAdapter);
        servicesMessageAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10)));
            }
        });
        servicesMessageAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("title","服务消息详情");
                intent.putExtra("id",list.get(position).getRec_id()+"");
                intent.putExtra("name",list.get(position).getMessage_title());
                intent.putExtra("time",list.get(position).getSend_time_text());
                intent.putExtra("content",list.get(position).getMessage_content());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.services_message_img_back:
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

    public void UpdateUI(int code,String msg, List<MessageNoticeBean.DataBean> data){
        LoadingClose();
        if (page==1) {
            list = data;
            servicesMessageAdapter.setListAll(list);
            mRecyclerView.refreshComplete();//刷新动画完成
        }else {
            if (data!=null||data.size()>0){
                list.addAll(data);
                servicesMessageAdapter.addItemsToLast(data);
            }else {
                page=1;
                mRecyclerView.setNoMore(true);//数据加载完成
            }
            mRecyclerView.loadMoreComplete();//加载动画完成
        }
        servicesMessageAdapter.notifyDataSetChanged();
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
