package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.InformationChoiceDetailContract;
import com.zhkj.syyj.presenter.InformationChoiceDetailPresenter;

public class InformationChoiceDetailModel implements InformationChoiceDetailContract.Model {

    //获取资讯详情
    public void  PostNewsDetail(final InformationChoiceDetailPresenter informationChoiceDetailPresenter, String id){
        OkGo.<String>get(RequstUrlUtils.URL.NewsDetail)
                .params("id",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                      informationChoiceDetailPresenter.SetNewsDetail(response.body());
                    }
                });

    }
}
