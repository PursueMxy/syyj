package com.zhkj.syyj.Beans;

import java.util.List;

public class DoneListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575379963
     * data : [{"id":6,"goods_id":2,"shop_price":"4999.00","original_img":"/uploads/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png","share_content":"aaaaa"},{"id":5,"goods_id":1,"shop_price":"2999.00","original_img":"/uploads/goods/2018/04-09/5d20aae3bd2954be026ae678ffd9ed58.png","share_content":"啦啦啦啦啦啦啦"}]
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
         * id : 6
         * goods_id : 2
         * shop_price : 4999.00
         * original_img : /uploads/goods/2018/04-09/fae5286b27e625cd1cad58dc63cc3af0.png
         * share_content : aaaaa
         */

        private int id;
        private int goods_id;
        private String shop_price;
        private String original_img;
        private String share_content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
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
    }
}
