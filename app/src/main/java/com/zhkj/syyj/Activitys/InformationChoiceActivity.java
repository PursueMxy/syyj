package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zhkj.syyj.Adapters.InformationChoiceAdapter;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.Beans.NewsListBean;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhkj.syyj.contract.InformationChoiceContract;
import com.zhkj.syyj.presenter.InformationChoicePresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class InformationChoiceActivity extends AppCompatActivity implements View.OnClickListener, InformationChoiceContract.View {

    private XRecyclerView mRecyclerView;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private InformationChoiceAdapter informationChoiceAdapter;
    private  List<NewsListBean.DataBean> list= new ArrayList<>();
    private InformationChoicePresenter informationChoicePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_choice);
        mContext = getApplicationContext();
        InitUI();
        informationChoicePresenter = new InformationChoicePresenter(this);
        informationChoicePresenter.GetNewList();
    }

    private void InitUI() {
        findViewById(R.id.information_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.information_XRecyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        informationChoiceAdapter = new InformationChoiceAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                informationChoicePresenter.GetNewList();
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        mRecyclerView.setAdapter(informationChoiceAdapter);
        informationChoiceAdapter.setListAll(list);
        informationChoiceAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, InformationChoiceDetailActivity.class);
                intent.putExtra("id",list.get(position).getArticle_id()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information_img_back:
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

    //更新列表
    public void UpdateUI(List<NewsListBean.DataBean> data){
        this.list=data;
        informationChoiceAdapter.setListAll(data);
        mRecyclerView.setAdapter(informationChoiceAdapter);
    }
}
