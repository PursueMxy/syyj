package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.contract.ShopFmSearchContract;
import com.zhkj.syyj.model.ShopFmSearchModel;

import java.util.List;

public class ShopFmSearchPresenter implements ShopFmSearchContract.Presenter {
    public ShopFmSearchContract.View mView;

    public ShopFmSearchModel shopFmSearchModel;

    public ShopFmSearchPresenter(ShopFmSearchContract.View view){
        this.mView=view;
        this.shopFmSearchModel=new ShopFmSearchModel();
    }

    public void GetSearchGoods(String uid,String token,String search){
     shopFmSearchModel.PostSearchGoods(this,uid,token,search);
    }

    //解析商品列表
    public void SetSearchGoods(String content){
        GoodsListBean goodsListBean = new GsonBuilder().create().fromJson(content, GoodsListBean.class);
        List<GoodsListBean.DataBean> data = goodsListBean.getData();
        mView.UpdateUI(goodsListBean.getCode(),goodsListBean.getMsg(),data);
    }
}
