package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ShoppingAddressAddContract;
import com.zhkj.syyj.presenter.ShoppingAddressAddPresenter;
import com.zhkj.syyj.presenter.ShoppingAddressPresenter;

public class ShoppingAddressAddModel implements ShoppingAddressAddContract.Model {
    /**
     * 新增地址
     * */
    public void PostAddressAdd(final ShoppingAddressAddPresenter shoppingAddressAddPresenter, String uid, String token, String address_id, String mobile, String consignee, String province, String city, String district, String twon, String address, String zipcode, String is_default){
        OkGo.<String>post(RequstUrlUtils.URL.SaveAddress)
                .params("uid",uid)
                .params("token",token)
                .params("address_id",address_id)
                .params("mobile",mobile)
                .params("consignee",consignee)
                .params("province",province)
                .params("city",city)
                .params("district",district)
                .params("twon",twon)
                .params("address",address)
                .params("zipcode",zipcode)
                .params("is_default",is_default)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                       shoppingAddressAddPresenter.SetAddressAdd(response.body());
                    }
                });

    }
}
