package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhkj.syyj.Adapters.ShopCartAdapter;
import com.zhkj.syyj.Beans.Products;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCartFragment extends Fragment {


    private View inflate;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private static List<Products> list= new ArrayList<>();
    private ShopCartAdapter shopCartAdapter;

    public ShopCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop_cart, container, false);
        mContext = getContext();
        InitUI();
        InitData();
        return inflate;
    }

    private void InitData() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void InitUI() {
        mRecyclerView = inflate.findViewById(R.id.fm_shop_cart_recyclerView);
        final Products products = new Products("1");
        final Products products2 = new Products("2");
        final Products products3 = new Products("3");
        list.add(products);
        list.add(products2);
        list.add(products3);
        list.add(products);
        list.add(products2);
        list.add(products3);
        list.add(products);
        list.add(products2);
        list.add(products3);
        list.add(products);
        list.add(products2);
        list.add(products3);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        shopCartAdapter = new ShopCartAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setFootViewText("拼命加载中","已经全部");
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        shopCartAdapter.setListAll(list);
        mRecyclerView.setAdapter(shopCartAdapter);
    }

}
