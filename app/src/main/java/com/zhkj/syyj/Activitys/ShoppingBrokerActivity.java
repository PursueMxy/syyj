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

import com.zhkj.syyj.Adapters.ShoppingBrokerAdapter;
import com.zhkj.syyj.Beans.CouponCenterBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ShoppingBrokerContract;
import com.zhkj.syyj.presenter.ShoppingBrokerPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBrokerActivity extends AppCompatActivity implements View.OnClickListener, ShoppingBrokerContract.View {

    private XRecyclerView mRecyclerView;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private List<CouponCenterBean.DataBean> list=new ArrayList<>();
    private ShoppingBrokerAdapter shoppingBrokerAdapter;
    private String token;
    private String uid;
    private ShoppingBrokerPresenter shoppingBrokerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_broker);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        shoppingBrokerPresenter = new ShoppingBrokerPresenter(this);
        shoppingBrokerPresenter.GetShoppingBroker(uid,token);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        shoppingBrokerPresenter.GetShoppingBroker(uid,token);
    }

    private void InitUI() {
       findViewById(R.id.ShoppingBroker_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.ShoppingBroker_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        shoppingBrokerAdapter = new ShoppingBrokerAdapter(this);
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
        mRecyclerView.setAdapter(shoppingBrokerAdapter);
        shoppingBrokerAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        ,0);
            }
        });
        shoppingBrokerAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, OrderPayActivity.class);
                intent.putExtra("id",list.get(position).getId()+"");
                intent.putExtra("type","coupon");
                intent.putExtra("money",list.get(position).getMoney()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ShoppingBroker_img_back:
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

    public void UpdateUI(int code,String msg,List<CouponCenterBean.DataBean> data){
       if (code==1){
         list=data;
         shoppingBrokerAdapter.setListAll(list);
         shoppingBrokerAdapter.notifyDataSetChanged();
       }else {
           ToastUtils.showToast(mContext,msg);
       }
    }
}
