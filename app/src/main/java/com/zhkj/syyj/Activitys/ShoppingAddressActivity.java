package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Adapters.ShoppingAddressAdapter;
import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.ShoppingAddressContract;
import com.zhkj.syyj.presenter.ShoppingAddressPresenter;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class  ShoppingAddressActivity extends AppCompatActivity implements View.OnClickListener, ShoppingAddressContract.View {

    private XRecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;
    private ShoppingAddressAdapter shoppingAddressAdapter;
    private List<AddressListBean.DataBean> tasklist_item=new ArrayList<>();
    private ShoppingAddressPresenter shoppingAddressPresenter;
    private String uid;
    private String token;
    private AlertDialog alertDialog;
    private String type="";
    private int ADDRESS_CODE=2001;
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_address);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        InitUI();
        shoppingAddressPresenter = new ShoppingAddressPresenter(this);
        LoadingDialog();
        shoppingAddressPresenter.GetAddressList(uid,token);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LoadingDialog();
        shoppingAddressPresenter.GetAddressList(uid,token);
    }

    private void InitUI() {
        findViewById(R.id.shopping_address_tv_add).setOnClickListener(this);
        findViewById(R.id.shopping_address_img_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.shopping_address_recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        shoppingAddressAdapter = new ShoppingAddressAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                shoppingAddressPresenter.GetAddressList(uid,token);
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        mRecyclerView.setAdapter(shoppingAddressAdapter);
        shoppingAddressAdapter.setListAll(tasklist_item);
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
        shoppingAddressAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                if (type.equals("select")){
                    Intent intent = new Intent(mContext,PlaceOrderActivity.class);
                    intent.putExtra("address_id",tasklist_item.get(position).getAddress_id()+"");
                    intent.putExtra("address",tasklist_item.get(position).getProvince()+tasklist_item.get(position).getCity()+tasklist_item.get(position).getDistrict() +tasklist_item.get(position).getTwon()+tasklist_item.get(position).getAddress());
                    intent.putExtra("contacts",tasklist_item.get(position).getConsignee()+"  "+tasklist_item.get(position).getMobile());
                    setResult(ADDRESS_CODE,intent);
                    finish();
                }
            }
        });
    }

    //获取收货列表
    public void UpdateAddressList(int code,String msg,List<AddressListBean.DataBean> data){
        LoadingClose();
        this.tasklist_item=data;
        shoppingAddressAdapter.setListAll(data);
        mRecyclerView.setAdapter(shoppingAddressAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shopping_address_tv_add:
                startActivity(new Intent(mContext,ShoppingAddressAddActivity.class));
                break;
            case R.id.shopping_address_img_back:
                finish();
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

   //删除收货地址
    public void DleAddress(final String address_id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shoppingAddressPresenter.GetDelAddress(uid,token,address_id);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        alertDialog = builder.setTitle("确认要删除")
                .setMessage("确认要删除该收货地址么")
                .create();
        alertDialog.show();
    }

    //设置默认地址
    public void defaultAddress(String address_id,String is_default){
        OkGo.<String>get(RequstUrlUtils.URL.defaultAddress)
                .params("uid",uid)
                .params("token",token)
                .params("address_id",address_id)
                .params("is_default",is_default)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1){
                            shoppingAddressPresenter.GetAddressList(uid,token);
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }

                    }
                });
    }

    //请求返回更新
    public void UpdateUI(int code,String msg){
        if (code==1){
            shoppingAddressPresenter.GetAddressList(uid,token);
        }
        ToastUtils.showToast(mContext,msg);
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
