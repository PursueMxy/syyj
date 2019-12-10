package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Adapters.CollectAdapter;
import com.zhkj.syyj.Adapters.SystemMessageAdapter;
import com.zhkj.syyj.Beans.MessageNoticeBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SystemMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private List<MessageNoticeBean.DataBean> list=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private SystemMessageAdapter systemMessageAdapter;
    private String uid;
    private String token;
    private int page=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_message);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        mContext = getApplicationContext();
        InitUI();
        GetMessage();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        GetMessage();
    }

    private void InitUI() {
        findViewById(R.id.system_message_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.system_message_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        systemMessageAdapter = new SystemMessageAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        mRecyclerView.setAdapter(systemMessageAdapter);
        systemMessageAdapter.setListAll(list);
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
        systemMessageAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("title","系统消息详情");
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
            case R.id.system_message_img_back:
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

    //获取消息列表
    public void GetMessage(){
        OkGo.<String>get(RequstUrlUtils.URL.MessageNoticeList)
                .params("uid",uid)
                .params("token",token)
                .params("category","0")
                .params("page",page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new GsonBuilder().create();
                        PublicResultBean publicResultBean = gson.fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            MessageNoticeBean messageNoticeBean = gson.fromJson(response.body(), MessageNoticeBean.class);
                            List<MessageNoticeBean.DataBean> data = messageNoticeBean.getData();
                            list=data;
                            systemMessageAdapter.setListAll(list);
                            systemMessageAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}
