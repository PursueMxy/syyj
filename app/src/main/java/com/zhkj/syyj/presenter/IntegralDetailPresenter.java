package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.IntegralDtlListBean;
import com.zhkj.syyj.Beans.IntegralListBean;
import com.zhkj.syyj.contract.IntegralDetailContract;
import com.zhkj.syyj.model.IntegralDetailModel;

import java.util.List;

public class IntegralDetailPresenter implements IntegralDetailContract.Presenter {

    public IntegralDetailContract.View mView;

    public IntegralDetailModel integralDetailModel;

    public IntegralDetailPresenter(IntegralDetailContract.View view){
     this.mView=view;
        integralDetailModel=new IntegralDetailModel();
    }

    //获取积分列表
    public void GetIntegralRecord(String uid,String token,int page){
        integralDetailModel.PostIntegralRecord(this,uid,token,page);
    }

    //解析积分列表
    public void  SetIntegralRecord(String content){
        IntegralDtlListBean integralDtlListBean = new GsonBuilder().create().fromJson(content, IntegralDtlListBean.class);
        List<IntegralDtlListBean.DataBean> data = integralDtlListBean.getData();
        mView.UpdateUI(integralDtlListBean.getCode(),integralDtlListBean.getMsg(),data);
    }
}
