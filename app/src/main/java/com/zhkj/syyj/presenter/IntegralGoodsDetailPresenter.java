package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.BuyIntegralGoodsBean;
import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.Beans.IntegralGoodsDetailBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.IntegralDetailContract;
import com.zhkj.syyj.contract.IntegralGoodsDetailContract;
import com.zhkj.syyj.model.IntegralDetailModel;
import com.zhkj.syyj.model.IntegralGoodsDetailModel;

public class IntegralGoodsDetailPresenter implements IntegralGoodsDetailContract.Presenter {
    public IntegralGoodsDetailContract.View mView;
    public IntegralGoodsDetailModel integralGoodsDetailModel;

    public IntegralGoodsDetailPresenter(IntegralGoodsDetailContract.View view){
        this.mView=view;
        integralGoodsDetailModel=new IntegralGoodsDetailModel();
    }

    //获取积分详情
    public void GetIntegraDetail(String uid,String token,String goods_id){
      integralGoodsDetailModel.PostIntegraDetail(this,uid,token,goods_id);
    }

    //解析积分商品详情
    public void SetIntegraDetail(String content){
        IntegralGoodsDetailBean integralGoodsDetailBean = new GsonBuilder().create().fromJson(content, IntegralGoodsDetailBean.class);
        IntegralGoodsDetailBean.DataBean data = integralGoodsDetailBean.getData();
        mView.UpdateUI(integralGoodsDetailBean.getCode(),integralGoodsDetailBean.getMsg(),data);
    }

    //立即兑换商品
    public void GetBuyIntegralGoods(String uid,String token,String goods_id,int item_id,int goods_num){
      integralGoodsDetailModel.PsotBuyIntegralGoods(this,uid,token,goods_id,item_id,goods_num);
    }

    //立即兑换解析
    public void SetBuyIntegralGoods(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateBuyIntegralGoods(publicResultBean.getCode(),publicResultBean.getMsg(),content);
    }
}
