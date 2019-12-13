package com.zhkj.syyj.Beans;

import java.util.List;

public class LogistisBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1576231317
     * data : [{"context":"【厦门市】  快件已由【菜鸟的厦门高林社239号101店】代签收, 如有问题请电联（13666015901 / 4001787878）, 感谢您使用中通快递, 期待再次为您服务!","time":"2019-11-13 16:08:00"},{"context":"【厦门市】  快件已到达 【厦门湖里五部】（0592-5220272、0592-5220238）,业务员 杨红有（13666015901） 正在第1次派件, 请保持电话畅通,并耐心等待（95720为中通快递员外呼专属号码，请放心接听）","time":"2019-11-13 15:26:58"},{"context":"【厦门市】  快件离开 【厦门中转部】 已发往 【厦门湖里五部】","time":"2019-11-13 04:27:51"},{"context":"【厦门市】  快件已经到达 【厦门中转部】","time":"2019-11-13 04:27:44"},{"context":"【泉州市】  快件离开 【泉州中转部】 已发往 【厦门中转部】","time":"2019-11-13 01:53:34"},{"context":"【泉州市】  快件已经到达 【泉州中转部】","time":"2019-11-13 01:51:22"},{"context":"【泉州市】  快件离开 【惠安】 已发往 【厦门中转部】","time":"2019-11-12 23:30:49"},{"context":"【泉州市】  【惠安】（18596890121、18596890112、18959771212） 的 惠安扫描员（1580280895） 已揽收","time":"2019-11-12 21:49:43"}]
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
         * context : 【厦门市】  快件已由【菜鸟的厦门高林社239号101店】代签收, 如有问题请电联（13666015901 / 4001787878）, 感谢您使用中通快递, 期待再次为您服务!
         * time : 2019-11-13 16:08:00
         */

        private String context;
        private String time;

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
