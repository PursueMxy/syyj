package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.BalanceBean;
import com.zhkj.syyj.contract.MyBalanceContract;
import com.zhkj.syyj.model.MyBalanceModel;

import java.util.List;

public class MyBalancePresenter implements MyBalanceContract.Presenter {
    public MyBalanceContract.View mView;
    public MyBalanceModel myBalanceModel;

    public MyBalancePresenter(MyBalanceContract.View view){
        this.mView=view;
        this.myBalanceModel=new MyBalanceModel();
    }

    //获取我的余额
    public void  GetBalance(String uid,String token){
        myBalanceModel.PostBalance(this,uid,token);
    }
    //数据解析
    public void SetBalance(String content){
        try {
            BalanceBean balanceBean = new GsonBuilder().create().fromJson(content, BalanceBean.class);
            BalanceBean.DataBean data = balanceBean.getData();
            mView.UpdateUI(balanceBean.getCode(),balanceBean.getMsg(),balanceBean.getData());
        }catch (Exception e){

        }

    }
}
