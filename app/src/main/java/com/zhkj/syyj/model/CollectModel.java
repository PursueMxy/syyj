package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.CollectContract;
import com.zhkj.syyj.presenter.CollectPresenter;

public class CollectModel implements CollectContract.Model {
    /**
     * 获取收藏列表
     */
   public void PostCollectList(CollectPresenter collectPresenter,String uid, String token, int page){
       OkGo.<String>get(RequstUrlUtils.URL.CollectList)
               .params("uid",uid)
               .params("token",token)
               .params("page",page)
               .execute(new StringCallback() {
                   @Override
                   public void onSuccess(Response<String> response) {
                      collectPresenter.SetCollectList(response.body());
                   }
               });
   }
}
