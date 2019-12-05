package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.IntegralContract;
import com.zhkj.syyj.presenter.IntegralPresenter;

public class IntegralModel implements IntegralContract.Model {
    /**
     * 获取积分分类
     */
    public void PostIntegralCategory(IntegralPresenter integralPresenter){
        OkGo.<String>post(RequstUrlUtils.URL.IntegralCategory)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                      integralPresenter.SetIntegralCategory(response.body());
                    }
                });
    }

    /**
     * 获取分类商城列表
     */
    public void PostIntegralMall(IntegralPresenter integralPresenter,int cat_id,int page){
        OkGo.<String>get(RequstUrlUtils.URL.IntegralMall)
                .params("cat_id",cat_id)
                .params("page",page)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    integralPresenter.SetIntegraMall(response.body());
                    }
                });
    }
}
