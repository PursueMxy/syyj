package com.zhkj.syyj.Beans;

public class IndexBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573197969
     * data : {"id":48,"nickname":"153****7579","headimg":"/uploads/headimg.jpg","user_money":"0.00","score":0,"level":1,"levelname":"普通会员","waitpay":0,"waitsend":0,"waitreceive":0}
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
         * nickname : 153****7579
         * headimg : /uploads/headimg.jpg
         * user_money : 0.00
         * score : 0
         * level : 1
         * levelname : 普通会员
         * waitpay : 0
         * waitsend : 0
         * waitreceive : 0
         */

        private int id;
        private String nickname;
        private String headimg;
        private String user_money;
        private int score;
        private int level;
        private String levelname;
        private int waitpay;
        private int waitsend;
        private int waitreceive;

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

        public String getUser_money() {
            return user_money;
        }

        public void setUser_money(String user_money) {
            this.user_money = user_money;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getLevelname() {
            return levelname;
        }

        public void setLevelname(String levelname) {
            this.levelname = levelname;
        }

        public int getWaitpay() {
            return waitpay;
        }

        public void setWaitpay(int waitpay) {
            this.waitpay = waitpay;
        }

        public int getWaitsend() {
            return waitsend;
        }

        public void setWaitsend(int waitsend) {
            this.waitsend = waitsend;
        }

        public int getWaitreceive() {
            return waitreceive;
        }

        public void setWaitreceive(int waitreceive) {
            this.waitreceive = waitreceive;
        }
    }
}
