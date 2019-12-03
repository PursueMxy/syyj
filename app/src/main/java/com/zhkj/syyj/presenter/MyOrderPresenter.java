package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.MyOrderContract;
import com.zhkj.syyj.model.MyOrderModel;

public class MyOrderPresenter implements MyOrderContract.Presenter {

    public MyOrderContract.View mView;

    public MyOrderModel myOrderModel;

    public MyOrderPresenter(MyOrderContract.View view){
        this.mView=view;
        this.myOrderModel=new MyOrderModel();
    }

    //获取订单
    public void GetMyOrder(String uid,String token,String type,int  page,int order_type){
        myOrderModel.PostOrderType(this,uid,token,type,page,order_type);
    }

    //解析订单
    public void SetMyOrder(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        int code = publicResultBean.getCode();
        if (code==1){
            mView.UpdateJson(publicResultBean.getCode(),publicResultBean.getMsg(),content);
        }
    }
}
