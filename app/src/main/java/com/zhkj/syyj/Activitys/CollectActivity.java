package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhkj.syyj.Adapters.CollectAdapter;
import com.zhkj.syyj.Beans.CollectListBean;
import com.zhkj.syyj.Beans.LiteCollectBean;
import com.zhkj.syyj.Beans.LiteGoodsCartBean;
import com.zhkj.syyj.Fragments.ShopCartFragment;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.CollectContract;
import com.zhkj.syyj.presenter.CollectPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener, CollectContract.View {

    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private CollectAdapter collectAdapter;
    private Context mContext;
    private List<String> addlist=new ArrayList<>();
    private CollectPresenter collectPresenter;
    private String uid;
    private String token;
    private int page=0;
    private List<LiteCollectBean> liteCollectBeanList=new ArrayList<>();
    private TextView tv_manage;
    private Button btn_delete;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    /**
     * 发送本地广播的action
     */
    public static final String LOCAL_BROADCAST = "com.zhkj.syyj.LOCAL_BROADCAST_COLLECT";
    private LocalReceiver localReceiver;
    private List<LiteCollectBean> liteCollectDeleteList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        InitUI();
        collectPresenter = new CollectPresenter(this);
        collectPresenter.GetCollectList(uid,token,page);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        collectPresenter.GetCollectList(uid,token,page);
    }

    private void InitUI() {
        //获取LocalBroadcastManager   本地广播管理者实例
        localBroadcastManager = LocalBroadcastManager.getInstance(mContext);
        localReceiver = new LocalReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(LOCAL_BROADCAST);   //添加action
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
        findViewById(R.id.collect_img_back).setOnClickListener(this);
        findViewById(R.id.collect_tv_manage).setOnClickListener(this);
        btn_delete = findViewById(R.id.collect_btn_delete);
        btn_delete.setOnClickListener(this);
        tv_manage = findViewById(R.id.collect_tv_manage);
        mRecyclerView = findViewById(R.id.collect_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        collectAdapter = new CollectAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setFootViewText("拼命加载中","已经全部");
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
//                collectAdapter.addItemsToLast(addlist);
//                collectAdapter.notifyDataSetChanged();
//                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
//                if(addlist.size()>5) {
                mRecyclerView.setNoMore(true);//数据加载完成
//                }
            }
        });
        mRecyclerView.setAdapter(collectAdapter);
        collectAdapter.setListAll(liteCollectBeanList);
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
        collectAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                intent.putExtra("goods_id",liteCollectBeanList.get(position).getGoods_id()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.collect_img_back:
                finish();
                break;
            case R.id.collect_tv_manage:
                String manage = tv_manage.getText().toString();
                if (manage.equals("管理")) {
                    LiteCollectBean liteCollectBean = new LiteCollectBean();
                    liteCollectBean.setIsShow("true");
                    liteCollectBean.setCollect_slt("false");
                    liteCollectBean.updateAll();
                    liteCollectBeanList = LitePal.findAll(LiteCollectBean.class);
                    collectAdapter.setListAll(liteCollectBeanList);
                    collectAdapter.notifyDataSetChanged();
                    btn_delete.setVisibility(View.VISIBLE);
                    tv_manage.setText("完成");
                }else if (manage.equals("完成")){
                    LiteCollectBean liteCollectBean = new LiteCollectBean();
                    liteCollectBean.setIsShow("false");
                    liteCollectBean.updateAll();
                    liteCollectBeanList = LitePal.findAll(LiteCollectBean.class);
                    collectAdapter.setListAll(liteCollectBeanList);
                    collectAdapter.notifyDataSetChanged();
                    tv_manage.setText("管理");
                    btn_delete.setVisibility(View.GONE);
                }
                break;
            case R.id.collect_btn_delete:
                liteCollectDeleteList = LitePal.where("collect_slt='true'").find(LiteCollectBean.class);
                DeleteCollect();
                break;
                default:
                    break;
        }
    }

    private void DeleteCollect() {
        String collect_id="";
       for (int a=0;a<liteCollectDeleteList.size();a++){
           if (a==0){
               collect_id=""+liteCollectDeleteList.get(a).getCollect_id();
           }else {
               collect_id= collect_id+","+liteCollectDeleteList.get(a).getCollect_id();
           }
       }
       collectPresenter.GetCollectGoods(uid,token,collect_id);
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

    public void UpdateUI(int code ,String msg,List<CollectListBean.DataBean> data){
      if (code==1){
          LitePal.deleteAll(LiteCollectBean.class);
          for (int  a=0;a<data.size();a++){
              LiteCollectBean liteCollectBean = new LiteCollectBean();
              liteCollectBean.setCollect_id(data.get(a).getCollect_id());
              liteCollectBean.setGoods_id(data.get(a).getGoods_id());
              liteCollectBean.setGoods_name(data.get(a).getGoods_name());
              liteCollectBean.setOriginal_img(data.get(a).getOriginal_img());
              liteCollectBean.setShop_price(data.get(a).getShop_price());
              liteCollectBean.setCollect_slt("false");
              liteCollectBean.setIsShow("false");
              liteCollectBean.save();
          }
          liteCollectBeanList = LitePal.findAll(LiteCollectBean.class);
          collectAdapter.setListAll(liteCollectBeanList);
          collectAdapter.notifyDataSetChanged();
          tv_manage.setText("管理");
          btn_delete.setVisibility(View.GONE);
      }else {
          ToastUtils.showToast(mContext,msg);
      }
    }

    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(!action.equals(LOCAL_BROADCAST)){
                return ;
            }
            boolean queryCity = intent.getBooleanExtra("collect",false);  //判断是否需要调用查询城市
            //如果是接收到需要查询城市信息的广播   则去执行该方法
            if(queryCity){
                liteCollectBeanList = LitePal.findAll(LiteCollectBean.class);
                collectAdapter.setListAll(liteCollectBeanList);
                collectAdapter.notifyDataSetChanged();
            }

        }
    }

    //返回通知
    public void UpdateUI(int code,String msg){
        if (code==1) {
            collectPresenter.GetCollectList(uid, token, page);
        }else {
            ToastUtils.showToast(mContext,msg);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);    //取消广播的注册
    }
}
