package com.zhkj.syyj.Beans;

import java.util.List;

public class MessageNoticeBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1575381467
     * data : [{"rec_id":215,"is_see":0,"send_time_text":"2019-11-29 00:00:00","send_time":1574956800,"message_title":"开奖咯","message_content":"哈哈哈，骗人的"},{"rec_id":214,"is_see":0,"send_time_text":"2019-11-15 15:29:28","send_time":1573802968,"message_title":"周五啦","message_content":"卧槽，周五啦啦啦"}]
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
         * rec_id : 215
         * is_see : 0
         * send_time_text : 2019-11-29 00:00:00
         * send_time : 1574956800
         * message_title : 开奖咯
         * message_content : 哈哈哈，骗人的
         */

        private int rec_id;
        private int is_see;
        private String send_time_text;
        private int send_time;
        private String message_title;
        private String message_content;

        public int getRec_id() {
            return rec_id;
        }

        public void setRec_id(int rec_id) {
            this.rec_id = rec_id;
        }

        public int getIs_see() {
            return is_see;
        }

        public void setIs_see(int is_see) {
            this.is_see = is_see;
        }

        public String getSend_time_text() {
            return send_time_text;
        }

        public void setSend_time_text(String send_time_text) {
            this.send_time_text = send_time_text;
        }

        public int getSend_time() {
            return send_time;
        }

        public void setSend_time(int send_time) {
            this.send_time = send_time;
        }

        public String getMessage_title() {
            return message_title;
        }

        public void setMessage_title(String message_title) {
            this.message_title = message_title;
        }

        public String getMessage_content() {
            return message_content;
        }

        public void setMessage_content(String message_content) {
            this.message_content = message_content;
        }
    }
}
