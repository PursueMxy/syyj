package com.zhkj.syyj.presenter;

import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.CollectListBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.contract.CollectContract;
import com.zhkj.syyj.model.CollectModel;

import java.util.List;

public class CollectPresenter implements CollectContract.Presenter {
    public CollectContract.View mView;

    public CollectModel collectModel;

    public CollectPresenter(CollectContract.View view){
        this.mView=view;
        this.collectModel=new CollectModel();
    }

    //获取收藏列表
    public void GetCollectList(String uid,String token,int page){
      collectModel.PostCollectList(this,uid,token,page);
    }

    //解析收藏列表
    public void SetCollectList(String conteng){
        CollectListBean collectListBean = new GsonBuilder().create().fromJson(conteng, CollectListBean.class);
        List<CollectListBean.DataBean> data = collectListBean.getData();
        mView.UpdateUI(collectListBean.getCode(),collectListBean.getMsg(),collectListBean.getData());
    }

    //取消收藏
    public void GetCollectGoods(String uid,String token,String goods_id){
           collectModel.PostCollectGoods(this,uid,token,goods_id);
    }

    public void SetPublicContent(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
    }
}
