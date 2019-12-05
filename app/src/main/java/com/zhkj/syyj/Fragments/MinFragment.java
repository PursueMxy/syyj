package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Activitys.CollectActivity;
import com.zhkj.syyj.Activitys.CouponActivity;
import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.IntegralActivity;
import com.zhkj.syyj.Activitys.MemberActivity;
import com.zhkj.syyj.Activitys.MyBalanceActivity;
import com.zhkj.syyj.Activitys.MyOrderActivity;
import com.zhkj.syyj.Activitys.NewsActivity;
import com.zhkj.syyj.Activitys.OrderTypeActivity;
import com.zhkj.syyj.Activitys.PerSonalDataActivity;
import com.zhkj.syyj.Activitys.ShoppingAddressActivity;
import com.zhkj.syyj.Beans.IndexBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MinFragment extends Fragment implements View.OnClickListener {


    private Context mContext;
    private View inflate;
    private String token;
    private String uid;
    private TextView tv_username;
    private ImageView img_head;
    private TextView tv_hy;
    private TextView tv_user_money;
    private TextView tv_level;
    private SharedPreferences share;
    private int level=0;
    private CustomProgressDialog progressDialog;

    public MinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_min, container, false);
        mContext = getContext();
        share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        InitData();
        return inflate;
    }

    public void InitData() {
        if (progressDialog == null){
            progressDialog = CustomProgressDialog.createDialog(mContext);
        }
        progressDialog.show();
        OkGo.<String>get(RequstUrlUtils.URL.Index)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (progressDialog != null){
                            progressDialog.dismiss();
                            progressDialog = null;
                        }
                        Gson gson = new GsonBuilder().create();
                        try {
                            IndexBean indexBean = gson.fromJson(response.body(), IndexBean.class);
                            if (indexBean.getCode()==1){
                                IndexBean.DataBean data = indexBean.getData();
                                if (data!=null){
                                    tv_username.setText(data.getNickname());
                                    Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getHeadimg()).into(img_head);
                                    tv_hy.setText(data.getLevelname());
                                    tv_user_money.setText("¥"+data.getUser_money());
                                    level = data.getLevel();
                                    tv_level.setText(data.getLevel()+"");
                                    SharedPreferences.Editor editor = share.edit();
                                    editor.putString("headimg", RequstUrlUtils.URL.HOST+data.getHeadimg());
                                    editor.putString("nickname",data.getNickname());
                                    editor.commit();
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void InitUI() {
       inflate.findViewById(R.id.fm_min_rel_my_order).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_my_balance).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_ll_member).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_img_head).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_shopping_address).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_collect).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_coupon).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_integarl).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rl_news).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rel_obligation).setOnClickListener(this);
       inflate.findViewById(R.id.fm_min_rel_tobe_shipped).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_tobe_received).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_orderDone).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_rel_task).setOnClickListener(this);
        inflate.findViewById(R.id.fm_min_my_integral).setOnClickListener(this);
        tv_username = inflate.findViewById(R.id.fm_min_tv_username);
        img_head = inflate.findViewById(R.id.fm_min_img_head);
        tv_hy = inflate.findViewById(R.id.fm_min_tv_hy);
        tv_user_money = inflate.findViewById(R.id.fm_min_tv_user_money);
        tv_level = inflate.findViewById(R.id.fm_min_tv_level);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fm_min_rel_my_order:
                Intent intent6 = new Intent(mContext, MyOrderActivity.class);
                intent6.putExtra("title","全部");
                startActivity(intent6);
                break;
            case R.id.fm_min_rel_obligation:
                Intent intent = new Intent(mContext, MyOrderActivity.class);
                intent.putExtra("title","待付款");
                startActivity(intent);
                break;
            case R.id.fm_min_rel_tobe_shipped:
                Intent intent1 = new Intent(mContext, MyOrderActivity.class);
                intent1.putExtra("title","待发货");
                startActivity(intent1);
                break;
            case R.id.fm_min_rel_tobe_received:
                Intent intent2 = new Intent(mContext, MyOrderActivity.class);
                intent2.putExtra("title","待收货");
                startActivity(intent2);
                break;
            case R.id.fm_min_rel_orderDone:
                Intent intent3 = new Intent(mContext, MyOrderActivity.class);
                intent3.putExtra("title","已完成");
                startActivity(intent3);
                break;
            case R.id.fm_min_my_balance:
                startActivity(new Intent(mContext, MyBalanceActivity.class));
                break;
            case R.id.fm_min_ll_member:
                startActivity(new Intent(mContext, MemberActivity.class));
                break;
            case R.id.fm_min_img_head:
                startActivity(new Intent(mContext, PerSonalDataActivity.class));
                break;
            case R.id.fm_min_shopping_address:
                startActivity(new Intent(mContext, ShoppingAddressActivity.class));
                break;
            case R.id.fm_min_rl_collect:
                startActivity(new Intent(mContext, CollectActivity.class));
                break;
            case R.id.fm_min_rl_coupon:
                startActivity(new Intent(mContext, CouponActivity.class));
                break;
            case R.id.fm_min_integarl:
                Intent intent7 = new Intent(mContext, IntegralActivity.class);
                intent7.putExtra("level",level+"");
                startActivity(intent7);
                break;
            case R.id.fm_min_rl_news:
                startActivity(new Intent(mContext, NewsActivity.class));
                break;
            case R.id.fm_min_rel_task:
                Intent intent4 = new Intent(mContext, HomeActivity.class);
                intent4.putExtra("currentItems","2");
                startActivity(intent4);
                break;
            case R.id.fm_min_my_integral:
                Intent intent5 = new Intent(mContext, IntegralActivity.class);
                intent5.putExtra("level",level+"");
                startActivity(intent5);
                break;
                default:
                    break;
        }
    }

}
