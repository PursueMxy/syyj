package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.InformationChoiceContract;
import com.zhkj.syyj.presenter.InformationChoicePresenter;

public class InformationChoiceModel implements InformationChoiceContract.Model {

    //获取资讯列表
    public void PostNewList(final InformationChoicePresenter informationChoicePresenter){
        OkGo.<String>get(RequstUrlUtils.URL.NewsList)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     informationChoicePresenter.SetNewList(response.body());
                    }
                });
    }
}
