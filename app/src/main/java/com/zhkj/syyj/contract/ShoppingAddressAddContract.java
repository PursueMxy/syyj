package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ShoppingAddressAddPresenter;

public interface ShoppingAddressAddContract {
    interface Model {
        void PostAddressAdd(ShoppingAddressAddPresenter shoppingAddressAddPresenter, String uid, String token, String address_id, String mobile, String consignee, String province, String city, String district, String twon, String address, String zipcode, String is_default);
    }

    interface View {
        void UpdateData(int code,String msg);
    }

    interface Presenter {
        void GetAddressAdd(String uid,String token,String address_id,String mobile,String consignee,String province,String city,String district,String twon,String address,String zipcode,String is_default);
        void SetAddressAdd(String content);
    }
}
