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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.FmShopSearchAdapter;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ShopFmSearchContract;
import com.zhkj.syyj.presenter.ShopFmSearchPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopFmSearchActivity extends AppCompatActivity implements View.OnClickListener, ShopFmSearchContract.View {
    private XRecyclerView shop_xRecyclerView;
    private LinearLayout ll_xre;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private FmShopSearchAdapter fmShopSearchAdapter;
    private static List<GoodsListBean.DataBean> list= new ArrayList<>();
    private TextView tv_search_null;
    private ShopFmSearchPresenter shopFmSearchPresenter;
    private String token;
    private String uid;
    private String search="";
    private EditText edt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fm_search);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        shopFmSearchPresenter = new ShopFmSearchPresenter(this);
        shopFmSearchPresenter.GetSearchGoods(uid,token,search);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        shopFmSearchPresenter.GetSearchGoods(uid,token,search);
    }

    private void InitUI() {
        findViewById(R.id.ShopFmSearch_img_back).setOnClickListener(this);
        findViewById(R.id.ShopFmSearch_tv_search).setOnClickListener(this);
        shop_xRecyclerView = findViewById(R.id.ShopFmSearch_xRecyclerView);
        tv_search_null = findViewById(R.id.ShopFmSearch_tv_search_null);
        edt_content = findViewById(R.id.ShopFmSearch_edt_content);
        ll_xre = findViewById(R.id.ShopFmSearch_ll_xre);
        shop_xRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        fmShopSearchAdapter = new FmShopSearchAdapter(mContext);
        shop_xRecyclerView.setLayoutManager(mLayoutManager);
        shop_xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                shop_xRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                shop_xRecyclerView.loadMoreComplete();//加载动画完成
                shop_xRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        shop_xRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10)));
            }
        });
        fmShopSearchAdapter.setListAll(list);
        shop_xRecyclerView.setAdapter(fmShopSearchAdapter);
        fmShopSearchAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id",list.get(position).getGoods_id()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ShopFmSearch_tv_search:
                shop_xRecyclerView.setVisibility(View.VISIBLE);
                search=edt_content.getText().toString();
                shopFmSearchPresenter.GetSearchGoods(uid,token,search);
                break;
            case R.id.ShopFmSearch_img_back:
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

    public void UpdateUI(int code,String msg,List<GoodsListBean.DataBean> data){
     if (code==1){
       list=data;
         fmShopSearchAdapter.setListAll(list);
         fmShopSearchAdapter.notifyDataSetChanged();
     }else {
         ToastUtils.showToast(mContext,msg);
     }
    }
}
