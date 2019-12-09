package com.zhkj.syyj.model;

import android.content.Intent;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Activitys.MyOrderActivity;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.OrderDetailContract;
import com.zhkj.syyj.presenter.OrderDetailPresenter;

public class OrderDetailModel implements OrderDetailContract.Model {
    //获取订单详情
    public void PostOrderDetail(final OrderDetailPresenter orderDetailPresenter, String uid, String token, String order_id){
        OkGo.<String>get(RequstUrlUtils.URL.OrderDetail)
                .params("uid",uid)
                .params("token",token)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     orderDetailPresenter.SetOrderDetail(response.body());
                    }
                });
    }

    //取消订单
    public void PostCancelOrder(OrderDetailPresenter orderDetailPresenter, String uid,String token,String order_id,String typename){
        OkGo.<String>get(RequstUrlUtils.URL.CancelOrder)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });


    }

    //删除订单
    public void PostDltOrder(OrderDetailPresenter orderDetailPresenter, String uid,String token,String order_id,String typename){
        OkGo.<String>get(RequstUrlUtils.URL.OrderDel_order)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });


    }
    //再次购买
    public void PostOrderOneMore(OrderDetailPresenter orderDetailPresenter, String uid,String token,String order_id,String typename){
        OkGo.<String>get(RequstUrlUtils.URL.CancelOrder)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });


    }

    //立即付款
    public void PostOrderOrderPay(OrderDetailPresenter orderDetailPresenter, String uid, String token, String order_id, String typename) {
        OkGo.<String>get(RequstUrlUtils.URL.OrderPay)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });
    }

    //确认收货
    public void PostConfirmOrder(OrderDetailPresenter orderDetailPresenter, String uid, String token, String order_id, String typename) {
        OkGo.<String>get(RequstUrlUtils.URL.OrderConfirm)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });
    }

    //订单支付未发货取消
    public void PostRecordRefundOrder(OrderDetailPresenter orderDetailPresenter, String uid, String token, String order_id, String typename) {
        OkGo.<String>get(RequstUrlUtils.URL.RecordRefundOrder)
                .params("token",token)
                .params("uid",uid)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        orderDetailPresenter.SetJsonData(response.body(),typename);
                    }
                });
    }
}
