package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Activitys.OrderDetailActivity;
import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.contract.OrderDetailContract;
import com.zhkj.syyj.model.OrderDetailModel;

public class OrderDetailPresenter implements OrderDetailContract.Presenter {

    public OrderDetailContract.View mView;
    public OrderDetailModel orderDetailModel;

    public OrderDetailPresenter(OrderDetailContract.View view){
        this.mView=view;
        orderDetailModel=new OrderDetailModel();
    }

    //获取产品详情
    public void  GetOrderDetail(String uid,String token,String order_id){
        orderDetailModel.PostOrderDetail(this,uid,token,order_id);
    }

    //返回数据解析
    public void  SetOrderDetail(String content){
        OrderDetailBean orderDetailBean = new GsonBuilder().create().fromJson(content, OrderDetailBean.class);
        mView.UpdateJson(orderDetailBean.getCode(),orderDetailBean.getMsg(),orderDetailBean.getData());
    }

}
