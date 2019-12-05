package com.zhkj.syyj.Beans;

public class UserBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575535701
     * data : {"id":48,"nickname":"mxy","headimg":"http://syapi.kuaishanghd.com/uploads/headimg.jpg","mobile":"153****7579"}
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
         * id : 48
         * nickname : mxy
         * headimg : http://syapi.kuaishanghd.com/uploads/headimg.jpg
         * mobile : 153****7579
         */

        private int id;
        private String nickname;
        private String headimg;
        private String mobile;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
