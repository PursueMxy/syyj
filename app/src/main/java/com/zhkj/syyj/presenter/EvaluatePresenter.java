package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.contract.EvaluateContract;
import com.zhkj.syyj.model.EvaluateModel;

public class EvaluatePresenter implements EvaluateContract.Presenter {
    public EvaluateContract.View mView;

    public EvaluateModel evaluateModel;

    public EvaluatePresenter(EvaluateContract.View view){
        this.mView=view;
        this.evaluateModel=new EvaluateModel();
    }

    //获取订单详情
    public void  GetOrderDetail(String uid,String token,String order_id){
        evaluateModel.PostOrderDetail(this,uid,token,order_id);
    }

    //返回数据解析
    public void  SetOrderDetail(String content){
        OrderDetailBean orderDetailBean = new GsonBuilder().create().fromJson(content, OrderDetailBean.class);
        mView.UpdateJson(orderDetailBean.getCode(),orderDetailBean.getMsg(),orderDetailBean.getData());
    }
}
