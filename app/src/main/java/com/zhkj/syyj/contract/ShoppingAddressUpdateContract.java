package com.zhkj.syyj.contract;

import com.zhkj.syyj.presenter.ShoppingAddressUpdatePresenter;

public interface ShoppingAddressUpdateContract {
    interface Model {
        void PostAddressUpdate(ShoppingAddressUpdatePresenter addressUpdatePresenter, String uid, String token, String address_id, String mobile, String consignee, String province, String city, String district, String twon, String address, String zipcode, String is_default);
    }

    interface View {
        void UpdateDatas(int code,String msg);
    }

    interface Presenter {
        void GetAddressUpdate(String uid,String token,String address_id,String mobile,String consignee,String province,String city,String district,String twon,String address,String zipcode,String is_default);
        void SetAddressUpdate(String content);
    }
}
