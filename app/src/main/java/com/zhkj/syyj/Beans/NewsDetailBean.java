package com.zhkj.syyj.Beans;

public class NewsDetailBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573464830
     * data : {"title":"新闻分类123","content":"<p>网页描述<\/p>","add_time":"2018-08-03 08:56:18"}
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
         * title : 新闻分类123
         * content : <p>网页描述</p>
         * add_time : 2018-08-03 08:56:18
         */

        private String title;
        private String content;
        private String add_time;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
