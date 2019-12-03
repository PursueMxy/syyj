package com.zhkj.syyj.presenter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.MessageNoticeBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.ServicesMessageContract;
import com.zhkj.syyj.model.ServicesMessageModel;

import java.util.List;

public class ServicesMessagePresenter implements ServicesMessageContract.Presenter {

    private ServicesMessageContract.View mView;
    private ServicesMessageModel servicesMessageModel;

    public ServicesMessagePresenter(ServicesMessageContract.View view){
        mView=view;
        servicesMessageModel=new ServicesMessageModel();
    }

    public void GetMessageNoticeList(String uid,String token,int category,int page){
     servicesMessageModel.PostMessageNoticeLis(this,uid,token,category,page);
    }

    public void SetMessageNoticeList(String content){
        Gson gson = new GsonBuilder().create();
        PublicResultBean publicResultBean = gson.fromJson(content, PublicResultBean.class);
        if (publicResultBean.getCode()==1){
            MessageNoticeBean messageNoticeBean = gson.fromJson(content, MessageNoticeBean.class);
            List<MessageNoticeBean.DataBean> data = messageNoticeBean.getData();
            mView.UpdateUI(messageNoticeBean.getCode(),messageNoticeBean.getMsg(),data);
        }
    }

}
