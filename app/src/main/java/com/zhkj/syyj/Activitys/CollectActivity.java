package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.CollectAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private List<String> list=new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private CollectAdapter collectAdapter;
    private Context mContext;
    private List<String> addlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        list.add("102");
        list.add("112");
        list.add("122");
        list.add("132");
        list.add("142");
        list.add("152");
        list.add("162");
        list.add("172");
        findViewById(R.id.collect_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.collect_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        collectAdapter = new CollectAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setFootViewText("拼命加载中","已经全部");
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                addlist.add("112");
                addlist.add("113");
                addlist.add("114");
                addlist.add("115");
                addlist.add("116");
                addlist.add("117");
                collectAdapter.addItemsToLast(addlist);
                collectAdapter.notifyDataSetChanged();
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                if(addlist.size()>5) {
                mRecyclerView.setNoMore(true);//数据加载完成
                }
            }
        });
        mRecyclerView.setAdapter(collectAdapter);
        collectAdapter.setListAll(list);
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
        findViewById(R.id.collect_tv_manage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.collect_img_back:
                finish();
                break;
            case R.id.collect_tv_manage:
                break;
                default:
                    break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
