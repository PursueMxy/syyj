package com.zhkj.syyj.Beans;

import com.google.gson.annotations.SerializedName;

public class WechatPayBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576135447
     * data : {"isNeedPay":1,"payInfo":{"appid":"wx04c242f527c2b352","partnerid":"1568125901","noncestr":"LoXC5RB7AMVNAcj0","prepayid":"wx12152407606278771fc7e0021737995600","package":"Sign=WXPay","timestamp":"1576135447","sign":"D621A5AD88F254B1CC253E992B5F57EF"}}
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
         * isNeedPay : 1
         * payInfo : {"appid":"wx04c242f527c2b352","partnerid":"1568125901","noncestr":"LoXC5RB7AMVNAcj0","prepayid":"wx12152407606278771fc7e0021737995600","package":"Sign=WXPay","timestamp":"1576135447","sign":"D621A5AD88F254B1CC253E992B5F57EF"}
         */

        private int isNeedPay;
        private PayInfoBean payInfo;

        public int getIsNeedPay() {
            return isNeedPay;
        }

        public void setIsNeedPay(int isNeedPay) {
            this.isNeedPay = isNeedPay;
        }

        public PayInfoBean getPayInfo() {
            return payInfo;
        }

        public void setPayInfo(PayInfoBean payInfo) {
            this.payInfo = payInfo;
        }

        public static class PayInfoBean {
            /**
             * appid : wx04c242f527c2b352
             * partnerid : 1568125901
             * noncestr : LoXC5RB7AMVNAcj0
             * prepayid : wx12152407606278771fc7e0021737995600
             * package : Sign=WXPay
             * timestamp : 1576135447
             * sign : D621A5AD88F254B1CC253E992B5F57EF
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
