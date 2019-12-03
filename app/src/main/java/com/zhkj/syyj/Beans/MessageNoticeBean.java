package com.zhkj.syyj.Beans;

import com.google.gson.annotations.SerializedName;

public class MessageNoticeBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1573439354
     * data : {"1":{"rec_id":202,"is_see":0,"send_time_text":"00:00","send_time":1574956800,"message_title":"开奖咯","message_content":"哈哈哈，骗人的"},"0":{"rec_id":201,"is_see":0,"send_time_text":"2019-11-01 17:57:52","send_time":1572602272,"message_title":"啦啦啦","message_content":"啊啊啊啊"}}
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
         * 1 : {"rec_id":202,"is_see":0,"send_time_text":"00:00","send_time":1574956800,"message_title":"开奖咯","message_content":"哈哈哈，骗人的"}
         * 0 : {"rec_id":201,"is_see":0,"send_time_text":"2019-11-01 17:57:52","send_time":1572602272,"message_title":"啦啦啦","message_content":"啊啊啊啊"}
         */

        @SerializedName("1")
        private _$1Bean _$1;
        @SerializedName("0")
        private _$0Bean _$0;

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public static class _$1Bean {
            /**
             * rec_id : 202
             * is_see : 0
             * send_time_text : 00:00
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

        public static class _$0Bean {
            /**
             * rec_id : 201
             * is_see : 0
             * send_time_text : 2019-11-01 17:57:52
             * send_time : 1572602272
             * message_title : 啦啦啦
             * message_content : 啊啊啊啊
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
}
