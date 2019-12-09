package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.EvaluateContract;
import com.zhkj.syyj.presenter.EvaluatePresenter;
import com.zhkj.syyj.presenter.OrderDetailPresenter;

public class EvaluateModel implements EvaluateContract.Model {
    //获取订单详情
    public void PostOrderDetail(final EvaluatePresenter evaluatePresenter, String uid, String token, String order_id){
        OkGo.<String>get(RequstUrlUtils.URL.OrderDetail)
                .params("uid",uid)
                .params("token",token)
                .params("order_id",order_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        evaluatePresenter.SetOrderDetail(response.body());
                    }
                });
    }
}
