package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yyydjk.library.BannerLayout;
import com.zhkj.syyj.Activitys.GoodsListActivity;
import com.zhkj.syyj.Activitys.ShopFmSearchActivity;
import com.zhkj.syyj.Adapters.FmShopAdapter;
import com.zhkj.syyj.Adapters.OnItemClickListener;
import com.zhkj.syyj.Adapters.RecyclerLeftAdapter;
import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.GlideImageLoader;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Context mContext;
    private EditText edt_content;
    private TextView tv_search;
    private TextView tv_search_null;
    private int SHOPFMSEARCH_CODE=1001;
    private String token;
    private String uid;
    private RecyclerView recycler_left;
    private List<CategoryListBean.DataBean.TmenuBean> tmenu=new ArrayList<>();
    private List<CategoryListBean.DataBean> datalist=new ArrayList<>();
    private LinearLayout ll_two_rec;
    private RecyclerLeftAdapter recyclerLeftAdapter;
    private XRecyclerView mRecyclerView;
    private FmShopAdapter fmShopAdapter;
    private List<CategoryListBean.DataBean.BannerBean> banner=new ArrayList<>();
    private View shop_top;
    //轮播图
    final List<String> urls = new ArrayList<>();
    private BannerLayout fm_shop_top_banner;
    private CustomProgressDialog progressDialog;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        mContext = getContext();
        SharedPreferences share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        InitData();
        return inflate;
    }

    public void InitData() {
       LoadingDialogShow();
        OkGo.<String>get(RequstUrlUtils.URL.CategoryList)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                      LoadingDialogClose();
                        Gson gson = new GsonBuilder().create();
                        CategoryListBean categoryListBean = gson.fromJson(response.body(), CategoryListBean.class);
                        if (categoryListBean.getCode()==1){
                            datalist = categoryListBean.getData();
                            recyclerLeftAdapter.refreshData(datalist);
                            recyclerLeftAdapter.notifyDataSetChanged();
                            if ( datalist.size()>0){
                                tmenu = datalist.get(0).getTmenu();
                                fmShopAdapter.setListAll(tmenu);
                                fmShopAdapter.notifyDataSetChanged();
                                banner = datalist.get(0).getBanner();
                                if (banner!=null){
                                    urls.clear();
                                    for (int a=0;a<banner.size();a++){
                                        urls.add(RequstUrlUtils.URL.HOST+ banner.get(a).getImg());
                                    }
                                    fm_shop_top_banner.setViewUrls(urls);
                                }
                            }
                        }else {
                            ToastUtils.showToast(mContext,categoryListBean.getMsg());
                        }
                    }
                });
    }

    private void InitUI() {
        shop_top = getLayoutInflater().inflate(R.layout.fm_shop_top, null);
        fm_shop_top_banner = shop_top.findViewById(R.id.fm_shop_top_banner);
        fm_shop_top_banner.setAutoPlay(true);
        fm_shop_top_banner.setImageLoader(new GlideImageLoader());
        //添加点击监听
        fm_shop_top_banner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        inflate.findViewById(R.id.fm_shop_rl_search).setOnClickListener(this);
        ll_two_rec = inflate.findViewById(R.id.fm_shop_ll_two_rec);
        recycler_left = inflate.findViewById(R.id.fm_shop_recycler_left);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recycler_left.setLayoutManager(layoutManager);
        recyclerLeftAdapter = new RecyclerLeftAdapter(mContext, datalist);
        recycler_left.setAdapter(recyclerLeftAdapter);
        mRecyclerView = inflate.findViewById(R.id.fm_shop_right_xrecycler);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.addHeaderView(shop_top);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        fmShopAdapter = new FmShopAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                InitData();
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        mRecyclerView.setAdapter(fmShopAdapter);
        fmShopAdapter.setListAll(tmenu);
        recyclerLeftAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                recyclerLeftAdapter.refreshSlt(position);
                recyclerLeftAdapter.notifyDataSetChanged();
                tmenu = datalist.get(position).getTmenu();
                banner = datalist.get(position).getBanner();
                fmShopAdapter.setListAll(tmenu);
                fmShopAdapter.notifyDataSetChanged();
                if (banner!=null){
                    urls.clear();
                    for (int a=0;a<banner.size();a++){
                        urls.add(RequstUrlUtils.URL.HOST+ banner.get(a).getImg());
                    }
                    fm_shop_top_banner.setViewUrls(urls);
                }
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5f);
    }
    /**
     * 获得资源 dimens (dp)
     *
     * @param context
     * @param id      资源id
     * @return
     */
    public float getDimens(Context context, int id) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float px = context.getResources().getDimension(id);
        return px / dm.density;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_shop_rl_search:
                Intent intent2 = new Intent(mContext, ShopFmSearchActivity.class);
                startActivityForResult(intent2,SHOPFMSEARCH_CODE);
                break;
                default:
                    break;
        }
    }

    public  void LoadingDialogShow(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(getContext());
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingDialogClose(){
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){}
    }


}
