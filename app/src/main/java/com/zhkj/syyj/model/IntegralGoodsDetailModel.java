package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.IntegralGoodsDetailContract;
import com.zhkj.syyj.presenter.IntegralGoodsDetailPresenter;

public class IntegralGoodsDetailModel implements IntegralGoodsDetailContract.Model {

    /**
     * 获取积分详情
     */
    public void PostIntegraDetail(IntegralGoodsDetailPresenter integralGoodsDetail, String uid, String token, String goods_id){
        OkGo.<String>get(RequstUrlUtils.URL.IntegraDetail)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",goods_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        integralGoodsDetail.SetIntegraDetail(response.body());
                    }
                });
    }

    /**
     * 立即兑换
     */
    public void  PsotBuyIntegralGoods(IntegralGoodsDetailPresenter integralGoodsDetail,String uid,String token,String goods_id,
                                      int item_id,int goods_num){
        OkGo.<String>post(RequstUrlUtils.URL.BuyIntegralGoods)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",goods_id)
                .params("item_id",item_id)
                .params("goods_num",goods_num)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    integralGoodsDetail.SetBuyIntegralGoods(response.body());
                    }
                });

    }

}
