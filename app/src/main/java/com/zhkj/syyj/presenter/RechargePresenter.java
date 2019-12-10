package com.zhkj.syyj.presenter;

import com.zhkj.syyj.contract.RechargeContract;
import com.zhkj.syyj.model.RechargeModel;

public class RechargePresenter implements RechargeContract.Presenter {

    public RechargeContract.View mView;

    public RechargeModel rechargeModel;

    public RechargePresenter(RechargeContract.View view){
        this.mView=view;
        this.rechargeModel=new RechargeModel();
    }

}
