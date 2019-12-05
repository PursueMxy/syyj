package com.zhkj.syyj.Beans;

public class UserInfoBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575533729
     * data : {"id":48,"nickname":"mxy","headimg":"/uploads/headimg/20191205/5de8b7b8d3d19.jpg","sex":1,"birthday":"2019-12-05","province":"福建","city":"思明区","district":"厦门市","career":"IT","wechat":"f"}
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
         * headimg : /uploads/headimg/20191205/5de8b7b8d3d19.jpg
         * sex : 1
         * birthday : 2019-12-05
         * province : 福建
         * city : 思明区
         * district : 厦门市
         * career : IT
         * wechat : f
         */

        private int id;
        private String nickname;
        private String headimg;
        private int sex;
        private String birthday;
        private String province;
        private String city;
        private String district;
        private String career;
        private String wechat;

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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = career;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }
    }
}
