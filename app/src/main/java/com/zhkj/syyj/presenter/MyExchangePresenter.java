package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.MyExchangeContract;
import com.zhkj.syyj.model.MyExchangeModel;

public class MyExchangePresenter implements MyExchangeContract.Presenter {
    public MyExchangeContract.View mView;

    public MyExchangeModel myExchangeModel;

    public MyExchangePresenter(MyExchangeContract.View view){
        this.mView=view;
        this.myExchangeModel=new MyExchangeModel();
    }

    //获取订单
    public void GetMyExchange(String uid,String token,String type,int  page,int order_type){
        myExchangeModel.PostExchangeType(this,uid,token,type,page,order_type);
    }

    //解析订单
    public void SetMyExchange(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        int code = publicResultBean.getCode();
        if (code==1){
            mView.UpdateJson(publicResultBean.getCode(),publicResultBean.getMsg(),content);
        }
    }
}
