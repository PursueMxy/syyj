package com.zhkj.syyj.Beans;

import com.google.gson.annotations.SerializedName;

public class WechatPayThreeBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576214992
     * data : {"payInfo":{"appid":"wx04c242f527c2b352","partnerid":"1568125901","noncestr":"ayIECo67tPHg1yV9","prepayid":"wx13132952018418c2a68e3d451708804500","package":"Sign=WXPay","timestamp":"1576214992","sign":"2981A9E122C0125DFBA91892FDB5F93E"},"payType":"weixin","isNeedPay":1}
     */

    private int code;
    private String msg;
    private int time;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * payInfo : {"appid":"wx04c242f527c2b352","partnerid":"1568125901","noncestr":"ayIECo67tPHg1yV9","prepayid":"wx13132952018418c2a68e3d451708804500","package":"Sign=WXPay","timestamp":"1576214992","sign":"2981A9E122C0125DFBA91892FDB5F93E"}
         * payType : weixin
         * isNeedPay : 1
         */

        private PayInfoBean payInfo;
        private String payType;
        private int isNeedPay;

        public PayInfoBean getPayInfo() {
            return payInfo;
        }

        public void setPayInfo(PayInfoBean payInfo) {
            this.payInfo = payInfo;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public int getIsNeedPay() {
            return isNeedPay;
        }

        public void setIsNeedPay(int isNeedPay) {
            this.isNeedPay = isNeedPay;
        }

        public static class PayInfoBean {
            /**
             * appid : wx04c242f527c2b352
             * partnerid : 1568125901
             * noncestr : ayIECo67tPHg1yV9
             * prepayid : wx13132952018418c2a68e3d451708804500
             * package : Sign=WXPay
             * timestamp : 1576214992
             * sign : 2981A9E122C0125DFBA91892FDB5F93E
             */

            private String appid;
            private String partnerid;
            private String noncestr;
            private String prepayid;
            @SerializedName("package")
            private String packageX;
            private String timestamp;
            private String sign;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
