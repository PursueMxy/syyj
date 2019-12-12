package com.zhkj.syyj.Beans;

import com.google.gson.annotations.SerializedName;

public class WechatPayTwoBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576143534
     * data : {"appid":"wx04c242f527c2b352","partnerid":"1568125901","noncestr":"BnDN0DTTammyq8WX","prepayid":"wx1217385486348125a031a2831211172500","package":"Sign=WXPay","timestamp":"1576143534","sign":"67447EBE0AF56DCC6CB8A8A73B8029E5"}
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
         * appid : wx04c242f527c2b352
         * partnerid : 1568125901
         * noncestr : BnDN0DTTammyq8WX
         * prepayid : wx1217385486348125a031a2831211172500
         * package : Sign=WXPay
         * timestamp : 1576143534
         * sign : 67447EBE0AF56DCC6CB8A8A73B8029E5
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
