package com.zhkj.syyj.Beans;

import java.util.List;

public class AddressListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573611352
     * data : [{"address_id":11,"user_id":48,"consignee":"mxy","province":"福建","city":"厦门市","district":"思明区","twon":"","address":"莲坂街道国贸大厦","zipcode":"361000","mobile":"15303987588","is_default":1,"longitude":"0.0000000","latitude":"0.0000000"}]
     */

    private int code;
    private String msg;
    private int time;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * address_id : 11
         * user_id : 48
         * consignee : mxy
         * province : 福建
         * city : 厦门市
         * district : 思明区
         * twon :
         * address : 莲坂街道国贸大厦
         * zipcode : 361000
         * mobile : 15303987588
         * is_default : 1
         * longitude : 0.0000000
         * latitude : 0.0000000
         */

        private int address_id;
        private int user_id;
        private String consignee;
        private String province;
        private String city;
        private String district;
        private String twon;
        private String address;
        private String zipcode;
        private String mobile;
        private int is_default;
        private String longitude;
        private String latitude;

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getTwon() {
            return twon;
        }

        public void setTwon(String twon) {
            this.twon = twon;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }
}
