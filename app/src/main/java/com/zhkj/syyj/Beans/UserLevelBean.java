package com.zhkj.syyj.Beans;

import java.util.List;

public class UserLevelBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573538284
     * data : {"user":{"id":48,"level":1,"total_consume":null},"level":[{"level_id":1,"level_name":"普通会员","amount":"0.00","discount":100,"icon":null,"describe":"若如初相见，若如初相恋","full_money":0,"back_cash":0},{"level_id":2,"level_name":"黄金会员","amount":"1000.00","discount":99,"icon":null,"describe":"","full_money":0,"back_cash":0},{"level_id":3,"level_name":"白金会员","amount":"3000.00","discount":94,"icon":null,"describe":"","full_money":0,"back_cash":0},{"level_id":4,"level_name":"钻石会员","amount":"10000.00","discount":95,"icon":null,"describe":"","full_money":0,"back_cash":0}]}
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
         * user : {"id":48,"level":1,"total_consume":null}
         * level : [{"level_id":1,"level_name":"普通会员","amount":"0.00","discount":100,"icon":null,"describe":"若如初相见，若如初相恋","full_money":0,"back_cash":0},{"level_id":2,"level_name":"黄金会员","amount":"1000.00","discount":99,"icon":null,"describe":"","full_money":0,"back_cash":0},{"level_id":3,"level_name":"白金会员","amount":"3000.00","discount":94,"icon":null,"describe":"","full_money":0,"back_cash":0},{"level_id":4,"level_name":"钻石会员","amount":"10000.00","discount":95,"icon":null,"describe":"","full_money":0,"back_cash":0}]
         */

        private UserBean user;
        private List<LevelBean> level;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<LevelBean> getLevel() {
            return level;
        }

        public void setLevel(List<LevelBean> level) {
            this.level = level;
        }

        public static class UserBean {
            /**
             * id : 48
             * level : 1
             * total_consume : null
             */

            private int id;
            private int level;
            private Object total_consume;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public Object getTotal_consume() {
                return total_consume;
            }

            public void setTotal_consume(Object total_consume) {
                this.total_consume = total_consume;
            }
        }

        public static class LevelBean {
            /**
             * level_id : 1
             * level_name : 普通会员
             * amount : 0.00
             * discount : 100
             * icon : null
             * describe : 若如初相见，若如初相恋
             * full_money : 0
             * back_cash : 0
             */

            private int level_id;
            private String level_name;
            private String amount;
            private int discount;
            private Object icon;
            private String describe;
            private int full_money;
            private int back_cash;

            public int getLevel_id() {
                return level_id;
            }

            public void setLevel_id(int level_id) {
                this.level_id = level_id;
            }

            public String getLevel_name() {
                return level_name;
            }

            public void setLevel_name(String level_name) {
                this.level_name = level_name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getFull_money() {
                return full_money;
            }

            public void setFull_money(int full_money) {
                this.full_money = full_money;
            }

            public int getBack_cash() {
                return back_cash;
            }

            public void setBack_cash(int back_cash) {
                this.back_cash = back_cash;
            }
        }
    }
}
