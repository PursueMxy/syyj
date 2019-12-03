package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.FmShopSearchAdapter;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShopFmSearchActivity extends AppCompatActivity implements View.OnClickListener {
    private XRecyclerView shop_xRecyclerView;
    private LinearLayout ll_xre;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private FmShopSearchAdapter fmShopSearchAdapter;
    private static List<Products> list= new ArrayList<>();
    private TextView tv_search_null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fm_search);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {

        Products products = new Products("1");
        Products products2 = new Products("2");
        Products products3 = new Products("3");
        list.add(products);
        list.add(products2);
        list.add(products3);
        findViewById(R.id.ShopFmSearch_img_back).setOnClickListener(this);
        findViewById(R.id.ShopFmSearch_tv_search).setOnClickListener(this);
        shop_xRecyclerView = findViewById(R.id.ShopFmSearch_xRecyclerView);
        tv_search_null = findViewById(R.id.ShopFmSearch_tv_search_null);
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
        fmShopSearchAdapter.setListAll(list);
        shop_xRecyclerView.setAdapter(fmShopSearchAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ShopFmSearch_tv_search:
                shop_xRecyclerView.setVisibility(View.VISIBLE);
//                tv_search_null.setVisibility(View.VISIBLE);
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
}
