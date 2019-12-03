package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ReMindContract;
import com.zhkj.syyj.model.ReMindModel;

public class ReMindPresenter implements ReMindContract.Presenter {

    public ReMindContract.View mView;
    public ReMindModel reMindModel;
    public ReMindPresenter(ReMindContract.View view){
        this.mView=view;
        reMindModel=new ReMindModel();
    }

    public void GetRemind(String uid,String token,String task_id,String date,String time,String content){
         reMindModel.PostRemind(this,uid,token,task_id,date,time,content);
    }

    public void SetReMind(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
    }
}
