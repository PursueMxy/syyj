package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.OrderTypeContract;
import com.zhkj.syyj.model.OrderTypeModel;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderTypePresenter implements OrderTypeContract.Presenter {

    public OrderTypeContract.View mView;
    public OrderTypeModel orderTypeModel;

    public OrderTypePresenter(OrderTypeContract.View view){
        this.mView=view;
        this.orderTypeModel=new OrderTypeModel();
    }

    //获取订单
    public void GetOrderType(String uid,String token,String type,int  page,int order_type){
       orderTypeModel.PostOrderType(this,uid,token,type,page,order_type);
    }

    //解析订单
    public void SetOrderType(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        int code = publicResultBean.getCode();
        if (code==1){
                mView.UpdateJson(publicResultBean.getCode(),publicResultBean.getMsg(),content);
            }
        }
}
