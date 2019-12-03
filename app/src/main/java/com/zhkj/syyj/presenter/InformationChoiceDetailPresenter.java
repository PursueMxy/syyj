package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.NewsDetailBean;
import com.zhkj.syyj.contract.InformationChoiceDetailContract;
import com.zhkj.syyj.model.InformationChoiceDetailModel;

public class InformationChoiceDetailPresenter implements InformationChoiceDetailContract.Presenter {

    public InformationChoiceDetailContract.View mView;
    public InformationChoiceDetailModel informationChoiceDetailModel;
    public InformationChoiceDetailPresenter(InformationChoiceDetailContract.View view){
        this.mView=view;
        informationChoiceDetailModel=new InformationChoiceDetailModel();
    }

    //获取资讯详情
    public void  getNewsDetail(String id){
   informationChoiceDetailModel.PostNewsDetail(this,id);
    }

    //得到资讯详情
    public void  SetNewsDetail(String content){
        try {
            NewsDetailBean newsDetailBean = new GsonBuilder().create().fromJson(content, NewsDetailBean.class);
            mView.UpdateNewsDetail(newsDetailBean);
        }catch (Exception e){

        }
    }
}
