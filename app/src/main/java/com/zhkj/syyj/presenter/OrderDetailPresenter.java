package com.zhkj.syyj.presenter;

import android.content.Intent;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Activitys.MyOrderActivity;
import com.zhkj.syyj.Activitys.OrderDetailActivity;
import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.OrderDetailContract;
import com.zhkj.syyj.model.OrderDetailModel;

public class OrderDetailPresenter implements OrderDetailContract.Presenter {

    public OrderDetailContract.View mView;
    public OrderDetailModel orderDetailModel;

    public OrderDetailPresenter(OrderDetailContract.View view){
        this.mView=view;
        orderDetailModel=new OrderDetailModel();
    }

    //获取订单详情
    public void  GetOrderDetail(String uid,String token,String order_id){
        orderDetailModel.PostOrderDetail(this,uid,token,order_id);
    }

    //返回数据解析
    public void  SetOrderDetail(String content){
        OrderDetailBean orderDetailBean = new GsonBuilder().create().fromJson(content, OrderDetailBean.class);
        mView.UpdateJson(orderDetailBean.getCode(),orderDetailBean.getMsg(),orderDetailBean.getData());
    }

    //取消订单
    public void  GetCancelOrder(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostCancelOrder(this,uid,token,order_id,typename);
    }

    //删除订单
    public void  GetDltOrder(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostDltOrder(this,uid,token,order_id,typename);
    }

    //再次购买
    public void  GetOrderOneMore(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostOrderOneMore(this,uid,token,order_id,typename);
    }

    //立即付款
    public void  GetOrderPay(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostOrderOrderPay(this,uid,token,order_id,typename);
    }

    //确认收货
    public void  GetConfirmOrder(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostConfirmOrder(this,uid,token,order_id,typename);
    }

    //取消订单已付款
    public void  GetRecordRefundOrder(String uid,String token,String order_id,String typename) {
        orderDetailModel.PostRecordRefundOrder(this,uid,token,order_id,typename);
    }



    //数据返回解析
    public void SetJsonData(String content,String typename){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
       mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg(),typename);
    }

}
