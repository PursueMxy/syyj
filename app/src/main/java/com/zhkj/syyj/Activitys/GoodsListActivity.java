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
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.CollectAdapter;
import com.zhkj.syyj.Adapters.GoodsListAdapter;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.GoodsListContract;
import com.zhkj.syyj.presenter.GoodsListPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.goods_list_tv_whole)
    TextView tv_whole;
    @BindView(R.id.goods_list_tv_salas)
    TextView tv_salas;
    @BindView(R.id.goods_list_tv_price)
    TextView tv_price;
    @BindView(R.id.goods_list_img_price)
    ImageView img_price;
    private boolean isasc=false;
    private String sort_asc="desc";
    private String sort="sort";
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        mContext = getApplicationContext();
        ButterKnife.bind(this);
        InitUI();
        goodsListPresenter = new GoodsListPresenter(this);
        LoadingDialog();
        goodsListPresenter.GetGoodsList(id,sort,sort_asc);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        goodsListPresenter.GetGoodsList(id,sort,sort_asc);
    }

    private void InitUI() {
        findViewById(R.id.goods_list_img_back).setOnClickListener(this);
        findViewById(R.id.goods_list_top_rl_whole).setOnClickListener(this);
        findViewById(R.id.goods_list_top_rl_salas).setOnClickListener(this);
        findViewById(R.id.goods_list_top_rl_price).setOnClickListener(this);
        findViewById(R.id.goods_list_img_price).setOnClickListener(this);
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
                intent.putExtra("img_item", RequstUrlUtils.URL.HOST+data_list.get(position).getOriginal_img());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goods_list_img_back:
                finish();
            case R.id.goods_list_top_rl_whole:
                sort="sort";
                tv_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
                tv_salas.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_price.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_whole.setTextColor(getResources().getColor(R.color.text_efb134));
                tv_salas.setTextColor(getResources().getColor(R.color.text_949397));
                tv_price.setTextColor(getResources().getColor(R.color.text_949397));
                goodsListPresenter.GetGoodsList(id,sort,sort_asc);
                break;
            case R.id.goods_list_top_rl_salas:
                sort="sales_sum ";
                tv_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_salas.setBackgroundResource(R.drawable.myorder_choosed_color);
                tv_price.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_whole.setTextColor(getResources().getColor(R.color.text_949397));
                tv_salas.setTextColor(getResources().getColor(R.color.text_efb134));
                tv_price.setTextColor(getResources().getColor(R.color.text_949397));
                goodsListPresenter.GetGoodsList(id,sort,sort_asc);
                break;
            case R.id.goods_list_top_rl_price:
                sort="shop_price";
                tv_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_salas.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                tv_price.setBackgroundResource(R.drawable.myorder_choosed_color);
                tv_whole.setTextColor(getResources().getColor(R.color.text_949397));
                tv_salas.setTextColor(getResources().getColor(R.color.text_949397));
                tv_price.setTextColor(getResources().getColor(R.color.text_efb134));
                goodsListPresenter.GetGoodsList(id,sort,sort_asc);
                break;
            case R.id.goods_list_img_price:
                if (isasc){
                    isasc=!isasc;
                    img_price.setImageResource(R.mipmap.ic_price_rise);
                    sort_asc="desc";
                }else {
                    isasc=!isasc;
                    img_price.setImageResource(R.mipmap.ic_price_down);
                    sort_asc="asc";
                }
                goodsListPresenter.GetGoodsList(id,sort,sort_asc);
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

    public void UpdateUI(int code, String msg, List<GoodsListBean.DataBean> data){
        LoadingClose();
        data_list=data;
        goodsListAdapter.setListAll(data_list);
        mRecyclerView.setAdapter(goodsListAdapter);
    }


    public void LoadingDialog(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(this);
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingClose(){
        try {
            if (progressDialog != null){
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){

        }
    }
}
