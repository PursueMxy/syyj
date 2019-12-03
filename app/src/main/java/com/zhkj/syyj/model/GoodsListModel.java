package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.GoodsListContract;
import com.zhkj.syyj.presenter.GoodsListPresenter;

public class GoodsListModel implements GoodsListContract.Model {
    //获取产品列表
    public void PostGoodsList(final GoodsListPresenter goodsListPresenter, String cat_id, String sort, String sort_asc){
        OkGo.<String>get(RequstUrlUtils.URL.GoodsList)
                .params("cat_id",cat_id)
                .params("sort",sort)
                .params("sort_asc",sort_asc)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        goodsListPresenter.SetGoodsList(response.body());
                    }
                });

    }
}
