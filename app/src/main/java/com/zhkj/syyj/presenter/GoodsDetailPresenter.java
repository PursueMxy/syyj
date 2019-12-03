package com.zhkj.syyj.presenter;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.model.GoodsDetailModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.sql.StatementEvent;

public class GoodsDetailPresenter implements GoodsDetailContract.Presenter {

    public GoodsDetailContract.View mView;
    public GoodsDetailModel goodsDetailModel;

    public GoodsDetailPresenter(GoodsDetailContract.View view){
        this.mView=view;
        goodsDetailModel=new GoodsDetailModel();
    }

    //获取产品详情
    public void GetGoodsDetail(String uid, String token, String goods_id){
      goodsDetailModel.PsotGoodsDetail(this,uid,token,goods_id);
    }

    public void SetGoodsDetail(String content){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(content);
            int code = jsonObject.getInt("code");
            String msg = jsonObject.getString("msg");
            String data = jsonObject.getString("data");
            mView.UpdateUI(code,msg,data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //加入购物车
    public void  GetCartAdd(String uid,String token,String goods_id,String item_id,String goods_num){
        goodsDetailModel.PostCardAdd(this,uid,token,goods_id,item_id,goods_num);
    }

    //立即购买
    public void  GetCartAdd2(String uid,String token,String goods_id,String item_id,String goods_num,String action){
        goodsDetailModel.PostCardAdd2(this,uid,token,goods_id,item_id,goods_num,action);
    }

    //加入购物车返回事件
    public void SetCartAdd(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateCartAdd(publicResultBean.getCode(),publicResultBean.getMsg());
    }

    //立即购买返回
    public void SetCartBuy(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateCartBuy(publicResultBean.getCode(),publicResultBean.getMsg(),content);

    }

    //收藏/取消收藏
    public void GetCollectGoods(String uid,String token,String goods_id){
       goodsDetailModel.PostCollectGoods(this,uid,token,goods_id);
    }

    public void SetPublicContent(String content){
        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(content, PublicResultBean.class);
        mView.UpdateUI(publicResultBean.getCode(),publicResultBean.getMsg());
    }


}
