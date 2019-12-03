package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.MemberContract;
import com.zhkj.syyj.presenter.MemberPresenter;

public class MemberModel implements MemberContract.Model {

    /**
     * 获取会员等级
    * */
    public void  PostMember(final MemberPresenter memberPresenter, String uid, String token){
        OkGo.<String>get(RequstUrlUtils.URL.UserLevel)
                .params("uid",uid)
                .params("token",token)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                    memberPresenter.SetMenber(response.body());
                    }
                });
    }
}
