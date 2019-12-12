package com.zhkj.syyj.Beans;

import java.util.List;

public class CouponCenterBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1576122516
     * data : [{"id":48,"name":"测试购买优惠券","money":"0.1","condition":10,"createnum":100,"send_num":0,"use_start_time":1576035538,"use_end_time":1581651538,"use_type":0,"price":0.01,"desc":null,"type":1,"isget":0,"type_title":"立减券","use_type_title":"全店通用","condition_title":"满10元可用"},{"id":47,"name":"无门槛优惠券","money":"0.1","condition":0,"createnum":100,"send_num":0,"use_start_time":1574667545,"use_end_time":1580024345,"use_type":0,"price":0,"desc":null,"type":1,"isget":0,"type_title":"立减券","use_type_title":"全店通用","condition_title":""},{"id":46,"name":"8.8折扣券啦","money":"8.8折","condition":100,"createnum":100,"send_num":0,"use_start_time":1574666660,"use_end_time":1580023460,"use_type":0,"price":0,"desc":null,"type":2,"isget":0,"type_title":"折扣券","use_type_title":"全店通用","condition_title":"满100元可用"},{"id":45,"name":"aaa","money":"100","condition":200,"createnum":100,"send_num":0,"use_start_time":1574836776,"use_end_time":1580020776,"use_type":0,"price":0,"desc":null,"type":3,"isget":0,"type_title":"满减券","use_type_title":"全店通用","condition_title":"满200元可用"},{"id":39,"name":"666","money":"20","condition":100,"createnum":100,"send_num":5,"use_start_time":1573972891,"use_end_time":1579329691,"use_type":2,"price":0,"desc":null,"type":1,"isget":0,"type_title":"立减券","use_type_title":"指定分类商品","condition_title":"满100元可用"}]
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
         * id : 48
         * name : 测试购买优惠券
         * money : 0.1
         * condition : 10
         * createnum : 100
         * send_num : 0
         * use_start_time : 1576035538
         * use_end_time : 1581651538
         * use_type : 0
         * price : 0.01
         * desc : null
         * type : 1
         * isget : 0
         * type_title : 立减券
         * use_type_title : 全店通用
         * condition_title : 满10元可用
         */

        private int id;
        private String name;
        private String money;
        private int condition;
        private int createnum;
        private int send_num;
        private int use_start_time;
        private int use_end_time;
        private int use_type;
        private double price;
        private Object desc;
        private int type;
        private int isget;
        private String type_title;
        private String use_type_title;
        private String condition_title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getCondition() {
            return condition;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        public int getCreatenum() {
            return createnum;
        }

        public void setCreatenum(int createnum) {
            this.createnum = createnum;
        }

        public int getSend_num() {
            return send_num;
        }

        public void setSend_num(int send_num) {
            this.send_num = send_num;
        }

        public int getUse_start_time() {
            return use_start_time;
        }

        public void setUse_start_time(int use_start_time) {
            this.use_start_time = use_start_time;
        }

        public int getUse_end_time() {
            return use_end_time;
        }

        public void setUse_end_time(int use_end_time) {
            this.use_end_time = use_end_time;
        }

        public int getUse_type() {
            return use_type;
        }

        public void setUse_type(int use_type) {
            this.use_type = use_type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Object getDesc() {
            return desc;
        }

        public void setDesc(Object desc) {
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIsget() {
            return isget;
        }

        public void setIsget(int isget) {
            this.isget = isget;
        }

        public String getType_title() {
            return type_title;
        }

        public void setType_title(String type_title) {
            this.type_title = type_title;
        }

        public String getUse_type_title() {
            return use_type_title;
        }

        public void setUse_type_title(String use_type_title) {
            this.use_type_title = use_type_title;
        }

        public String getCondition_title() {
            return condition_title;
        }

        public void setCondition_title(String condition_title) {
            this.condition_title = condition_title;
        }
    }
}
