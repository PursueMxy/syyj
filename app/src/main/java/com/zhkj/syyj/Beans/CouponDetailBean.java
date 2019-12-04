package com.zhkj.syyj.Beans;

public class CouponDetailBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575454722
     * data : {"id":44,"name":"测试","send_type":1,"money":"10","condition":100,"createnum":100,"send_num":1,"use_start_time":1574580867,"use_end_time":1579937667,"use_type":0,"price":0,"desc":null,"type":1,"type_title":"立减券","use_type_title":"全店通用","condition_title":"满100元可用","isget":1,"status":1}
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
         * id : 44
         * name : 测试
         * send_type : 1
         * money : 10
         * condition : 100
         * createnum : 100
         * send_num : 1
         * use_start_time : 1574580867
         * use_end_time : 1579937667
         * use_type : 0
         * price : 0
         * desc : null
         * type : 1
         * type_title : 立减券
         * use_type_title : 全店通用
         * condition_title : 满100元可用
         * isget : 1
         * status : 1
         */

        private int id;
        private String name;
        private int send_type;
        private String money;
        private int condition;
        private int createnum;
        private int send_num;
        private int use_start_time;
        private int use_end_time;
        private int use_type;
        private int price;
        private Object desc;
        private int type;
        private String type_title;
        private String use_type_title;
        private String condition_title;
        private int isget;
        private int status;

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

        public int getSend_type() {
            return send_type;
        }

        public void setSend_type(int send_type) {
            this.send_type = send_type;
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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
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

        public int getIsget() {
            return isget;
        }

        public void setIsget(int isget) {
            this.isget = isget;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
