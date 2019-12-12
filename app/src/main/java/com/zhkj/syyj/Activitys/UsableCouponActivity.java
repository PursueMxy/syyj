package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.CouponAdapter;
import com.zhkj.syyj.Adapters.UsableCouponAdapter;
import com.zhkj.syyj.Beans.CouponBean;
import com.zhkj.syyj.Beans.PlaceOrderBean;
import com.zhkj.syyj.Beans.UsableCouponBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UsableCouponActivity extends AppCompatActivity {

    @BindView(R.id.usable_coupon_recyclerView)
    XRecyclerView mRecyclerView;
    private Context mContext;
    private String coupon;
    private List<PlaceOrderBean.DataBean.UserCartCouponListBean> userCartCouponList=new ArrayList<>();
    private UsableCouponAdapter couponAdapter;
    private int COUPON_CODE=2002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usable_coupon);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        coupon = intent.getStringExtra("coupon");
        ButterKnife.bind(this);
        InitUI();
        InitData();
    }

    //解析数据
    private void InitData() {
        PlaceOrderBean placeOrderBean = new GsonBuilder().create().fromJson(coupon, PlaceOrderBean.class);
        PlaceOrderBean.DataBean data = placeOrderBean.getData();
        userCartCouponList = data.getUserCartCouponList();
        couponAdapter.setListAll(userCartCouponList);
        couponAdapter.notifyDataSetChanged();

    }

    private void InitUI() {
        mRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        couponAdapter = new UsableCouponAdapter(this);
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
        mRecyclerView.setAdapter(couponAdapter);
        couponAdapter.setListAll(userCartCouponList);
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
        couponAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext,PlaceOrderActivity.class);
                intent.putExtra("cid",userCartCouponList.get(position).getCid()+"");
                intent.putExtra("name",userCartCouponList.get(position).getCoupon().getName());
                intent.putExtra("coupon_money",userCartCouponList.get(position).getCoupon().getMoney());
                setResult(COUPON_CODE,intent);
                finish();
            }
        });
    }

    @OnClick({R.id.usable_coupon_back})
    public void  onViewClick(View view){
        switch (view.getId()){
            case R.id.usable_coupon_back:
                finish();
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
