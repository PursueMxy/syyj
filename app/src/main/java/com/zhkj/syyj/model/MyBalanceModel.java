package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.MyBalanceContract;
import com.zhkj.syyj.presenter.MyBalancePresenter;

public class MyBalanceModel implements MyBalanceContract.Model {

    //获取个人余额
    public void  PostBalance(final MyBalancePresenter myBalancePresenter, String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.Balance)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                     myBalancePresenter.SetBalance(response.body());
                    }
                });
    }
}
