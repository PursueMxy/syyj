package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.AppraiseContract;
import com.zhkj.syyj.presenter.AppraisePresenter;

public class AppraiseModel implements AppraiseContract.Model {

    public void PostGoodsComment(AppraisePresenter appraisePresenter,int  page, String goods_id, int type ){
        OkGo.<String>get(RequstUrlUtils.URL.GoodsComment)
                .params("page",page)
                .params("goods_id",goods_id)
                .params("type",type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     appraisePresenter.SetGoodsComment(response.body());
                    }
                });

    }
}
