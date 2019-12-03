package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.UpdateUserContract;
import com.zhkj.syyj.presenter.UpdateUserPresenter;

public class UpdateUserModel implements UpdateUserContract.Model {

    /**
     * 更改个人信息
     */
    public void PostSaveUserInfo(UpdateUserPresenter updateUserPresenter,String uid,String token,String nickname,String headimg,String sex,String birthday,String province,String city,String district,String career,String wechat){
        OkGo.<String>post(RequstUrlUtils.URL.SaveUserInfo)
                .params("uid",uid)
                .params("token",token)
                .params("nickname",nickname)
                .params("headimg",headimg)
                .params("sex",sex)
                .params("birthday",birthday)
                .params("province",province)
                .params("city",city)
                .params("district",district)
                .params("career",career)
                .params("wechat",wechat)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }

}
