package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.contract.GoodsListContract;
import com.zhkj.syyj.model.GoodsListModel;

import java.util.List;

public class GoodsListPresenter implements GoodsListContract.Presenter {

    public GoodsListContract.View mView;
    public GoodsListModel goodsListModel;

    public GoodsListPresenter(GoodsListContract.View view){
        this.mView=view;
        goodsListModel=new GoodsListModel();
    }

    //获取商品列表
    public void GetGoodsList(String cat_id,String sort,String sort_asc){
        goodsListModel.PostGoodsList(this,cat_id,sort,sort_asc);
    }

    //商品列表
    public void SetGoodsList(String content){
        GoodsListBean goodsListBean = new GsonBuilder().create().fromJson(content, GoodsListBean.class);
        List<GoodsListBean.DataBean> data = goodsListBean.getData();
        mView.UpdateUI(goodsListBean.getCode(),goodsListBean.getMsg(),data);

    }
}
