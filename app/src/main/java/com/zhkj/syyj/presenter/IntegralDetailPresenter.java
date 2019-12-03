package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.IntegralDetailContract;
import com.zhkj.syyj.model.IntegralDetailModel;

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
}
