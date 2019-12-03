package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.MessageDetailContract;
import com.zhkj.syyj.presenter.MessageDetailPresenter;

public class MessageDetailModel implements MessageDetailContract.Model {
    /**
     * 获取消息详情
     */
    public void PostMessage_notice_info(MessageDetailPresenter messageDetailPresenter,String uid,String token,String rec_id){
        OkGo.<String>get(RequstUrlUtils.URL.Message_notice_info)
                .params("uid",uid)
                .params("token",token)
                .params("rec_id",rec_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }
}
