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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.CouponAdapter;
import com.zhkj.syyj.Beans.CouponBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.contract.CouponContract;
import com.zhkj.syyj.presenter.CouponPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CouponActivity extends AppCompatActivity implements View.OnClickListener, CouponContract.View {

    private Context mContext;
    private XRecyclerView mRecyclerView;
    private List<CouponBean.DataBean> list=new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private CouponAdapter couponAdapter;
    private ImageView img_shopping_broker;
    private RadioButton radiobutton_whole;
    private RadioButton radiobutton_obligation;
    private RadioButton radiobutton_to_bo_shipped;
    private RadioButton radiobutton_to_bo_received;
    private CouponPresenter couponPresenter;
    private String token;
    private String uid;
    private String type="";
    private int page=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        couponPresenter = new CouponPresenter(this);
        couponPresenter.GetCoupon(uid,token,type,page);
    }

    private void InitUI() {
        findViewById(R.id.coupon_img_back).setOnClickListener(this);
        img_shopping_broker = findViewById(R.id.coupon_img_shopping_broker);
        img_shopping_broker.setOnClickListener(this);
        mRecyclerView = findViewById(R.id.coupon_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        couponAdapter = new CouponAdapter(this);
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
        couponAdapter.setListAll(list);
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
                Intent intent = new Intent(mContext, CouponDetailActivity.class);
                intent.putExtra("Cid",list.get(position).getCid()+"");
                startActivity(intent);
            }
        });
       RadioGroup coupon_radioGroup= findViewById(R.id.coupon_radioGroup);
        radiobutton_whole = findViewById(R.id.coupon_radiobutton_whole);
        radiobutton_obligation = findViewById(R.id.coupon_radiobutton_obligation);
        radiobutton_to_bo_shipped = findViewById(R.id.coupon_radiobutton_to_bo_shipped);
        radiobutton_to_bo_received = findViewById(R.id.coupon_radiobutton_to_bo_received);
        coupon_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.coupon_radiobutton_obligation:
                        type="0";
                        couponPresenter.GetCoupon(uid,token,type,page);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.coupon_radiobutton_to_bo_shipped:
                        type="1";
                        couponPresenter.GetCoupon(uid,token,type,page);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.coupon_radiobutton_to_bo_received:
                        type="2";
                        couponPresenter.GetCoupon(uid,token,type,page);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
                        break;
                    case R.id.coupon_radiobutton_whole:
                        type="";
                        couponPresenter.GetCoupon(uid,token,type,page);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coupon_img_back:
                finish();
                break;
            case R.id.coupon_img_shopping_broker:
                startActivity(new Intent(mContext,ShoppingBrokerActivity.class));
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void UpdateUI(int code ,String msg,List<CouponBean.DataBean> data){
        list=data;
        couponAdapter.setListAll(list);
        couponAdapter.notifyDataSetChanged();
    }
}
