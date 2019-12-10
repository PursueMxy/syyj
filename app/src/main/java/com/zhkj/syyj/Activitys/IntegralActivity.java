package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.IntegralAdapter;
import com.zhkj.syyj.Adapters.IntergralTopAdapter;
import com.zhkj.syyj.Adapters.OnItemClickListener;
import com.zhkj.syyj.Beans.IntegralCategoryBean;
import com.zhkj.syyj.Beans.IntegralListBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.IntegralContract;
import com.zhkj.syyj.presenter.IntegralPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.zhouyou.recyclerview.manager.StateGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class IntegralActivity extends AppCompatActivity implements View.OnClickListener, IntegralContract.View {

    private RecyclerView top_recyclerView;
    private List<IntegralListBean.DataBean> list=new ArrayList<>();
    private List<IntegralCategoryBean.DataBean> IntegralCategoryList=new ArrayList<>();
    private IntergralTopAdapter intergralTopAdapter;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private StateGridLayoutManager mLayoutManager;
    private IntegralAdapter integralAdapter;
    private TextView tv_myintegral;
    private String level;
    private String token;
    private String uid;
    private IntegralPresenter integralPresenter;
    private CustomProgressDialog progressDialog;
    private int page=0;
    private int cat_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        Intent intent = getIntent();
        level = intent.getStringExtra("level");
        mContext = getApplicationContext();
        InitUI();
        if (progressDialog == null){
            progressDialog = CustomProgressDialog.createDialog(this);
        }
        progressDialog.show();
        integralPresenter = new IntegralPresenter(this);
        integralPresenter.GetIntegralCategory();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        integralPresenter.GetIntegralCategory();
    }

    private void InitUI() {
        findViewById(R.id.integral_img_back).setOnClickListener(this);
        findViewById(R.id.integral_tv_detail).setOnClickListener(this);
        findViewById(R.id.integral_tv_exchange).setOnClickListener(this);
        top_recyclerView = findViewById(R.id.integral_top_recyclerView);
        tv_myintegral = findViewById(R.id.integral_tv_myintegral);
        tv_myintegral.setText("我的积分："+level);
        intergralTopAdapter = new IntergralTopAdapter(this,IntegralCategoryList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        top_recyclerView.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        top_recyclerView.setNestedScrollingEnabled(false);
        top_recyclerView.setAdapter(intergralTopAdapter);
        intergralTopAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (progressDialog == null){
                    progressDialog = CustomProgressDialog.createDialog(IntegralActivity.this);
                }
                progressDialog.show();
                intergralTopAdapter.UpdateItem(position);
                page=0;
                cat_id=IntegralCategoryList.get(position).getId();
                integralPresenter.GetIntegralMall(cat_id,page);
            }
        });
        mRecyclerView = findViewById(R.id.integral_recycleView_item);
        mRecyclerView.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //解决item跳动
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        integralAdapter = new IntegralAdapter(this);
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
        mRecyclerView.setAdapter(integralAdapter );
        integralAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_15)));
            }
        });

        integralAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, IntegralGoodsDetailActivity.class);
                intent.putExtra("goods_id",list.get(position).getGoods_id()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.integral_img_back:
                finish();
                break;
            case R.id.integral_tv_detail:
                startActivity(new Intent(mContext,IntegralDetailActivity.class));
                break;
            case R.id.integral_tv_exchange:
                Intent intent = new Intent(mContext, MyExchangeActivity.class);
                intent.putExtra("type","");
                startActivity(intent);
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

    public void UpdateIntegralCategory(int code,String msg,List<IntegralCategoryBean.DataBean> data){
        IntegralCategoryList.clear();
        if (code==1){
            IntegralCategoryList=data;
            if (IntegralCategoryList.size()>0){
                page=0;
                cat_id=IntegralCategoryList.get(0).getId();
                integralPresenter.GetIntegralMall(cat_id,page);
            }
            intergralTopAdapter.RecherList(IntegralCategoryList);
        }else {
            ToastUtils.showToast(mContext,msg);
        }
    }

    public void UpdateUI(int code,String msg,List<IntegralListBean.DataBean> data){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
        list.clear();
        if (code==1){
            list=data;
        }
        integralAdapter.setListAll(list);
        integralAdapter.notifyItemInserted(1);
    }
}
