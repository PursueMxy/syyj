package com.zhkj.syyj.Beans;

import java.util.List;

public class BalanceBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1573731745
     * data : {"balance":"94873.00","log":[{"time":1573721062,"money":"-1709.00","desc":"下单消费"},{"time":1573722391,"money":"-1709.00","desc":"下单消费"},{"time":1573723248,"money":"-1709.00","desc":"下单消费"}]}
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
         * balance : 94873.00
         * log : [{"time":1573721062,"money":"-1709.00","desc":"下单消费"},{"time":1573722391,"money":"-1709.00","desc":"下单消费"},{"time":1573723248,"money":"-1709.00","desc":"下单消费"}]
         */

        private String balance;
        private List<LogBean> log;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public List<LogBean> getLog() {
            return log;
        }

        public void setLog(List<LogBean> log) {
            this.log = log;
        }

        public static class LogBean {
            /**
             * time : 1573721062
             * money : -1709.00
             * desc : 下单消费
             */

            private int time;
            private String money;
            private String desc;

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
