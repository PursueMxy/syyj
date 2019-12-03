package com.zhkj.syyj.Beans;

import java.util.List;

public class TaskListsBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1573455306
     * data : {"taskList":[{"id":1,"market_price":"3198.00","shop_price":"2999.00","original_img":"/public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","share_content":"啦啦啦啦啦啦啦","share_imgs":["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"],"is_done":0},{"id":2,"market_price":"5299.00","shop_price":"4999.00","original_img":"/public/upload/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png","share_content":"aaaaa","share_imgs":[],"is_done":0}],"status":{"status":0,"start_time":0,"end_time":0,"msg":"未开始"}}
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
         * taskList : [{"id":1,"market_price":"3198.00","shop_price":"2999.00","original_img":"/public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","share_content":"啦啦啦啦啦啦啦","share_imgs":["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"],"is_done":0},{"id":2,"market_price":"5299.00","shop_price":"4999.00","original_img":"/public/upload/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png","share_content":"aaaaa","share_imgs":[],"is_done":0}]
         * status : {"status":0,"start_time":0,"end_time":0,"msg":"未开始"}
         */

        private StatusBean status;
        private List<TaskListBean> taskList;

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
        }

        public List<TaskListBean> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskListBean> taskList) {
            this.taskList = taskList;
        }

        public static class StatusBean {
            /**
             * status : 0
             * start_time : 0
             * end_time : 0
             * msg : 未开始
             */

            private int status;
            private int start_time;
            private int end_time;
            private String msg;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getStart_time() {
                return start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }
        }

        public static class TaskListBean {
            /**
             * id : 1
             * market_price : 3198.00
             * shop_price : 2999.00
             * original_img : /public/upload/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png
             * share_content : 啦啦啦啦啦啦啦
             * share_imgs : ["09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png","09/5d20aae3bd2954be026ae678ffd9ed58.png"]
             * is_done : 0
             */

            private int id;
            private String market_price;
            private String shop_price;
            private String original_img;
            private String share_content;
            private int is_done;
            private List<String> share_imgs;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public String getShare_content() {
                return share_content;
            }

            public void setShare_content(String share_content) {
                this.share_content = share_content;
            }

            public int getIs_done() {
                return is_done;
            }

            public void setIs_done(int is_done) {
                this.is_done = is_done;
            }

            public List<String> getShare_imgs() {
                return share_imgs;
            }

            public void setShare_imgs(List<String> share_imgs) {
                this.share_imgs = share_imgs;
            }
        }
    }
}
