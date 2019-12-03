package com.zhkj.syyj.Beans;

import java.util.List;

public class NewsListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573462656
     * data : [{"article_id":4,"title":"新闻分类123","description":"yuyudnf","thumb":"/images/icon_goods_thumb_empty_300.png","add_time":"2018-08-03 08:56:18"},{"article_id":5,"title":"达达1","description":"我是描述","thumb":"/images/icon_goods_thumb_empty_300.png","add_time":"2018-08-03 09:00:34"}]
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
         * article_id : 4
         * title : 新闻分类123
         * description : yuyudnf
         * thumb : /images/icon_goods_thumb_empty_300.png
         * add_time : 2018-08-03 08:56:18
         */

        private int article_id;
        private String title;
        private String description;
        private String thumb;
        private String add_time;

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
