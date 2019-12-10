package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Beans.UserLevelBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.MemberContract;
import com.zhkj.syyj.presenter.MemberPresenter;

import java.util.ArrayList;
import java.util.List;

public class MemberActivity extends AppCompatActivity implements MemberContract.View {

    private MemberPresenter memberPresenter;
    private SharedPreferences share;
    private String mobile;
    private String token;
    private String uid;
    private String headimg;
    private String nickname;
    private ImageView img_head;
    private Context mContext;
    private TextView tv_nickname;
    private TextView tv_to_level_name;
    private TextView tv_discount;
    private TextView tv_back_cash;
    private ImageView img_lever_one;
    private ImageView img_lever_two;
    private ImageView img_lever_three;
    private ImageView img_lever_four;
    private TextView tv_lever_one;
    private TextView tv_lever_two;
    private TextView tv_lever_three;
    private TextView tv_lever_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        mContext = getApplicationContext();
        memberPresenter = new MemberPresenter(this);
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        mobile = share.getString("mobile", "");
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        headimg = share.getString("headimg", "");
        nickname = share.getString("nickname", "");
        InitUI();
        InitData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        InitData();
    }

    private void InitData() {
        memberPresenter.GetMember(uid,token);
    }

    private void InitUI() {
        img_head = findViewById(R.id.member_img_head);
        tv_nickname = findViewById(R.id.member_tv_nickname);
        tv_to_level_name = findViewById(R.id.member_tv_to_level_name);
        tv_discount = findViewById(R.id.member_tv_discount);
        tv_back_cash = findViewById(R.id.member_tv_back_cash);
        img_lever_one = findViewById(R.id.member_img_lever_one);
        img_lever_two = findViewById(R.id.member_img_lever_two);
        img_lever_three = findViewById(R.id.member_img_lever_three);
        img_lever_four = findViewById(R.id.member_img_lever_four);
        tv_lever_one = findViewById(R.id.member_tv_lever_one);
        tv_lever_two = findViewById(R.id.member_tv_lever_two);
        tv_lever_three = findViewById(R.id.member_tv_lever_three);
        tv_lever_four = findViewById(R.id.member_tv_lever_four);
        tv_nickname.setText(nickname);
        Glide.with(mContext).load(headimg).into(img_head);
        findViewById(R.id.member_img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //返回数据更新UI
    public void UpdateUI(int code, String msg, UserLevelBean.DataBean  data){
        if (code==1){
            UserLevelBean.DataBean.UserBean user = data.getUser();
            List<UserLevelBean.DataBean.LevelBean> level = data.getLevel();
            if (user.getLevel()==1){
                tv_to_level_name.setText("还需消费"+ level.get(1).getAmount()+"元，提升到黄金会员");
                  tv_discount.setText("会员享受全场"+ level.get(0).getDiscount()+"折");
                  tv_back_cash.setText("订单满"+ level.get(0).getFull_money()+"元，返还"+ level.get(0).getBack_cash()+"元\n" + "到绑定的支付方式中");
                  img_lever_one.setBackground(getResources().getDrawable(R.drawable.img_gold));
                  Glide.with(mContext).load( imageTranslateUri(R.mipmap.ic_member_gold_zero)).into(img_lever_one);
                  tv_lever_one.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
              }else if (user.getLevel()==2){
                  tv_to_level_name.setText("还需消费"+ level.get(2).getAmount()+"元，提升到白金会员");
                  tv_discount.setText("会员享受全场"+ level.get(1).getDiscount()+"折");
                  tv_back_cash.setText("订单满"+ level.get(1).getFull_money()+"元，返还"+ level.get(1).getBack_cash()+"元\n" + "到绑定的支付方式中");
                  img_lever_two.setBackground(getResources().getDrawable(R.drawable.img_gold));
                  Glide.with(mContext).load( imageTranslateUri(R.mipmap.ic_member_gold_one)).into(img_lever_two);
                  tv_lever_two.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
              }else if (user.getLevel()==3){
                  tv_to_level_name.setText("还需消费"+ level.get(3).getAmount()+"元，提升到钻石会员");
                  tv_discount.setText("会员享受全场"+ level.get(2).getDiscount()+"折");
                  tv_back_cash.setText("订单满"+ level.get(2).getFull_money()+"元，返还"+level.get(2).getBack_cash()+"元\n" + "到绑定的支付方式中");
                  img_lever_three.setBackground(getResources().getDrawable(R.drawable.img_gold));
                  Glide.with(mContext).load( imageTranslateUri(R.mipmap.ic_member_gold_two)).into(img_lever_three);
                  tv_lever_three.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
              }else if (user.getLevel()==4){
                  tv_to_level_name.setText("恭喜您已经成为钻石会员");
                  tv_discount.setText("会员享受全场"+level.get(3).getDiscount()+"折");
                  tv_back_cash.setText("订单满"+ level.get(3).getFull_money()+"元，返还"+ level.get(3).getBack_cash()+"元\n" + "到绑定的支付方式中");
                  img_lever_four.setBackground(getResources().getDrawable(R.drawable.img_gold));
                  Glide.with(mContext).load(imageTranslateUri(R.mipmap.ic_member_gold_three)).into(img_lever_four);
                  tv_lever_four.setTextColor(mContext.getResources().getColor(R.color.text_efb134));
              }
        }

    }

    private String imageTranslateUri(int resId) {

        Resources r = getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(resId) + "/"
                + r.getResourceTypeName(resId) + "/"
                + r.getResourceEntryName(resId));

        return uri.toString();
    }

}
