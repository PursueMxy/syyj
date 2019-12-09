package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.GoodsCommentBean;
import com.zhkj.syyj.contract.AppraiseContract;
import com.zhkj.syyj.model.AppraiseModel;

import java.util.List;

public class AppraisePresenter implements AppraiseContract.Presenter {

    public AppraiseContract.View mView;

    public AppraiseModel appraiseModel;

    public AppraisePresenter(AppraiseContract.View view){
        this.mView=view;
        this.appraiseModel=new AppraiseModel();
    }

    //获取评论列表
    public void GetGoodsComment(int  page,String goods_id,int type ){
        appraiseModel.PostGoodsComment(this,page,goods_id,type);
    }

    //解析评论列表
    public void SetGoodsComment(String content){
        GoodsCommentBean goodsCommentBean = new GsonBuilder().create().fromJson(content, GoodsCommentBean.class);
        List<GoodsCommentBean.DataBean> data = goodsCommentBean.getData();
        mView.UpdateUI(goodsCommentBean.getCode(),goodsCommentBean.getMsg(),data);
    }
}
