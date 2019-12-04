package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.CollectAdapter;
import com.zhkj.syyj.Adapters.GoodsListAdapter;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.contract.GoodsListContract;
import com.zhkj.syyj.presenter.GoodsListPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GoodsListActivity extends AppCompatActivity implements View.OnClickListener, GoodsListContract.View {

    private XRecyclerView mRecyclerView;
    private TextView tv_title;
    private String id;
    private String name;
    private GoodsListPresenter goodsListPresenter;
    List<GoodsListBean.DataBean> data_list=new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private GoodsListAdapter goodsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        mContext = getApplicationContext();
        InitUI();
        goodsListPresenter = new GoodsListPresenter(this);
        goodsListPresenter.GetGoodsList(id,"sales_sum","asc");
    }

    private void InitUI() {
        findViewById(R.id.goods_list_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.goods_detail_recyclerView);
        tv_title = findViewById(R.id.goods_list_tv_title);
        tv_title.setText(name);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        goodsListAdapter = new GoodsListAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setFootViewText("拼命加载中","已经全部");
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
        mRecyclerView.setAdapter(goodsListAdapter);
        goodsListAdapter.setListAll(data_list);
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
        goodsListAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id",data_list.get(position).getGoods_id()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goods_list_img_back:
                finish();
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

    public void UpdateUI(int code, String msg, List<GoodsListBean.DataBean> data){
        data_list=data;
        goodsListAdapter.setListAll(data_list);
        mRecyclerView.setAdapter(goodsListAdapter);
    }
}
