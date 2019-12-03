package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.OrderTypeContract;
import com.zhkj.syyj.presenter.OrderTypePresenter;

public class OrderTypeModel implements OrderTypeContract.Model {

  public void PostOrderType(final OrderTypePresenter orderTypePresenter, String uid, String token, String type, int  page, final int order_type){
      OkGo.<String>get(RequstUrlUtils.URL.OrderList)
              .params("uid",uid)
              .params("token",token)
              .params("type",type)
              .params("page",page)
              .params("order_type",order_type)
              .execute(new StringCallback() {
                  @Override
                  public void onSuccess(Response<String> response) {
                      orderTypePresenter.SetOrderType(response.body());
                  }
              });

  }

}
