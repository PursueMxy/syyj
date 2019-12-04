package com.zhkj.syyj.Beans;

import java.util.List;

public class CouponBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575443850
     * data : [{"id":126,"cid":44,"send_type":1,"uid":49,"use_time":1574819372,"code":"","send_time":1574667346,"status":1,"name":"测试","money":"10","use_start_time":1574580867,"use_end_time":1579937667,"condition":100,"type":1,"condition_title":"满100元可用","type_title":"立减券","use_type_title":"全店通用"},{"id":125,"cid":38,"send_type":1,"uid":49,"use_time":1574778928,"code":"","send_time":1574667254,"status":1,"name":"hhh","money":"10","use_start_time":1574145211,"use_end_time":1579329211,"condition":100,"type":1,"condition_title":"满100元可用","type_title":"立减券","use_type_title":"全店通用"},{"id":121,"cid":39,"send_type":1,"uid":49,"use_time":0,"code":"","send_time":1574071382,"status":0,"name":"666","money":"20","use_start_time":1573972891,"use_end_time":1579329691,"condition":100,"type":1,"condition_title":"满100元可用","type_title":"立减券","use_type_title":"指定分类商品","category_id":62,"category_name":"手机"},{"id":124,"cid":42,"send_type":0,"uid":49,"use_time":1574235954,"code":"","send_time":1574071382,"status":1,"name":"测试","money":"10","use_start_time":1574065028,"use_end_time":1579335428,"condition":100,"type":1,"condition_title":"满100元可用","type_title":"立减券","use_type_title":"全店通用"}]
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
         * id : 126
         * cid : 44
         * send_type : 1
         * uid : 49
         * use_time : 1574819372
         * code :
         * send_time : 1574667346
         * status : 1
         * name : 测试
         * money : 10
         * use_start_time : 1574580867
         * use_end_time : 1579937667
         * condition : 100
         * type : 1
         * condition_title : 满100元可用
         * type_title : 立减券
         * use_type_title : 全店通用
         * category_id : 62
         * category_name : 手机
         */

        private int id;
        private int cid;
        private int send_type;
        private int uid;
        private int use_time;
        private String code;
        private int send_time;
        private int status;
        private String name;
        private String money;
        private int use_start_time;
        private int use_end_time;
        private int condition;
        private int type;
        private String condition_title;
        private String type_title;
        private String use_type_title;
        private int category_id;
        private String category_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getSend_type() {
            return send_type;
        }

        public void setSend_type(int send_type) {
            this.send_type = send_type;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getUse_time() {
            return use_time;
        }

        public void setUse_time(int use_time) {
            this.use_time = use_time;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getSend_time() {
            return send_time;
        }

        public void setSend_time(int send_time) {
            this.send_time = send_time;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public int getCondition() {
            return condition;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCondition_title() {
            return condition_title;
        }

        public void setCondition_title(String condition_title) {
            this.condition_title = condition_title;
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

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
}
