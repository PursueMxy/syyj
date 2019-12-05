package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.IntegralCategoryBean;
import com.zhkj.syyj.Beans.IntegralListBean;
import com.zhkj.syyj.contract.IntegralContract;
import com.zhkj.syyj.model.IntegralModel;

import java.util.List;

public class IntegralPresenter implements IntegralContract.Presenter {
    public IntegralContract.View mView;

    public IntegralModel integralModel;

    public IntegralPresenter(IntegralContract.View view){
        mView=view;
        integralModel=new IntegralModel();
    }

    //获取积分分类
    public void GetIntegralCategory(){
         integralModel.PostIntegralCategory(this);
    }

    //积分分类数据解析
    public void SetIntegralCategory(String content){
        IntegralCategoryBean integralBean = new GsonBuilder().create().fromJson(content, IntegralCategoryBean.class);
        List<IntegralCategoryBean.DataBean> data = integralBean.getData();
        mView.UpdateIntegralCategory(integralBean.getCode(),integralBean.getMsg(),data);
    }

    //获取积分商城列表
    public void GetIntegralMall(int cat_id,int page){
        integralModel.PostIntegralMall(this,cat_id,page);
    }

    //解析商城列表详情
    public void SetIntegraMall(String content){
        IntegralListBean integralListBean = new GsonBuilder().create().fromJson(content, IntegralListBean.class);
        List<IntegralListBean.DataBean> data = integralListBean.getData();
        mView.UpdateUI(integralListBean.getCode(),integralListBean.getMsg(),data);
    }

}
