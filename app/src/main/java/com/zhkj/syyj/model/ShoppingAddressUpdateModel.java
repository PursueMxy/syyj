package com.zhkj.syyj.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.contract.ShoppingAddressUpdateContract;
import com.zhkj.syyj.presenter.ShoppingAddressUpdatePresenter;

public class ShoppingAddressUpdateModel implements ShoppingAddressUpdateContract.Model {

    //更改收货地址
    @Override
    public void PostAddressUpdate(final ShoppingAddressUpdatePresenter addressUpdatePresenter, String uid, String token, String address_id, String mobile, String consignee, String province, String city, String district, String twon, String address, String zipcode, String is_default) {
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
                        addressUpdatePresenter.SetAddressUpdate(response.body());
                    }
                });
    }
}
