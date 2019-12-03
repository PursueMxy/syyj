package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;
import com.zhkj.syyj.presenter.GoodsListPresenter;

public class GoodsDetailModel implements GoodsDetailContract.Model {

    /**
     *获取商品详情
     */
    public void PsotGoodsDetail(final GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id){
        OkGo.<String>get(RequstUrlUtils.URL.GoodsInfo)
                .params("uid",uid)
                .params("token",token)
                .params("id",goods_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                   goodsDetailPresenter.SetGoodsDetail(response.body());
                    }
                });
    }


    /**
     * 加入购物车
     */
    public void PostCardAdd(final GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id, String item_id, String goods_num){
      OkGo.<String>post(RequstUrlUtils.URL.CartAdd)
              .params("uid",uid)
              .params("token",token)
              .params("goods_id",goods_id)
              .params("item_id",item_id)
              .params("goods_num",goods_num)
              .execute(new StringCallback() {
                  @Override
                  public void onSuccess(Response<String> response) {
                      goodsDetailPresenter.SetCartAdd(response.body());
                  }
              });
    }


    /**
     * 立即购买
     */
    public void PostCardAdd2(final GoodsDetailPresenter goodsDetailPresenter, String uid, String token, String goods_id, String item_id, String goods_num, String action){
        OkGo.<String>post(RequstUrlUtils.URL.CartAdd2)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",goods_id)
                .params("item_id",item_id)
                .params("goods_num",goods_num)
                .params("action",action)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        goodsDetailPresenter.SetCartBuy(response.body());
                    }
                });
    }


    /**
     * 收藏/取消收藏
     */
    public void PostCollectGoods(final GoodsDetailPresenter goodsDetailPresenter, String uid,String token,String goods_id){
        OkGo.<String>get(RequstUrlUtils.URL.GoodsCollectGoods)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",goods_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                 goodsDetailPresenter.SetPublicContent(response.body());
                    }
                });
    }
}
