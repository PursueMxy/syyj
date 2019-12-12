package com.zhkj.syyj.Beans;

public class WechatLoginBean {

    /**
     * code : 1
     * msg : 未绑定手机号
     * time : 1576133122
     * data : {"isBand":0,"uid":52}
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
         * isBand : 0
         * uid : 52
         */

        private int isBand;
        private int uid;
        private String token;

        public int getIsBand() {
            return isBand;
        }

        public void setIsBand(int isBand) {
            this.isBand = isBand;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
