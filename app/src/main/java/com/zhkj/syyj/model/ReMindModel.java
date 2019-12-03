package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ReMindContract;
import com.zhkj.syyj.presenter.ReMindPresenter;

public class ReMindModel implements ReMindContract.Model {
    /**
     * @param task_id 任务ID
     * @param date 日期
     * @param time 时间
     * @param content 内容
     *
     */
    public void  PostRemind(final ReMindPresenter reMindPresenter, String uid, String token, String task_id, String date, String time, String content){
        OkGo.<String>post(RequstUrlUtils.URL.TaskSetRemind)
                .params("uid",uid)
                .params("token",token)
                .params("task_id",task_id)
                .params("date",date)
                .params("time",time)
                .params("content",content)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        reMindPresenter.SetReMind(response.body());
                    }
                });
    }
}
