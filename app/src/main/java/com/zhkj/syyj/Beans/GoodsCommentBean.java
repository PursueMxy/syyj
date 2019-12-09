package com.zhkj.syyj.Beans;

import java.util.List;

public class GoodsCommentBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1575794195
     * data : [{"content":"1112321323","add_time":"2019-11-23 14:22:36","goods_rank":1,"headimg":"/uploads/2/20191127/5ddde9930592d.jpg","nickname":"130****4551","spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送女友"},{"content":"Dssssn","add_time":"2019-11-22 17:15:09","goods_rank":1,"headimg":"/uploads/2/20191127/5ddde9930592d.jpg","nickname":"130****4551","spec_key_name":"选择种类:选择10斤装 种类:礼品盒装 场景:送孩子"},{"content":"123456756789123456789123456756789123456789123456756789123456789123456756789123456789123456756789123456789123456756789123","add_time":"2018-04-27 17:42:51","goods_rank":3,"headimg":"/public/upload/head_pic/20180424/47684cc3e684a14cc2aae4a9294bf87e.jpg","nickname":"15247471414","spec_key_name":null},{"content":"天空","add_time":"2018-04-27 16:39:22","goods_rank":3,"headimg":null,"nickname":null,"spec_key_name":null},{"content":"关于风风光光不回家","add_time":"2018-04-26 17:29:34","goods_rank":3,"headimg":"/public/upload/head_pic/20180427/dd96cecf4bc0bd6414351cd9574d01e7.jpg","nickname":"13243434343","spec_key_name":null},{"content":"啦啦啦阿拉啦啦啦啦2","add_time":"2018-04-26 14:09:38","goods_rank":2,"headimg":"/public/upload/head_pic/20180419/fec83644525cdd715416db8789cfe222.jpg","nickname":"青春","spec_key_name":null},{"content":"很好436458855很好43645885","add_time":"2018-04-24 15:46:45","goods_rank":3,"headimg":"/public/upload/head_pic/20180424/47684cc3e684a14cc2aae4a9294bf87e.jpg","nickname":"15247471414","spec_key_name":null}]
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
         * content : 1112321323
         * add_time : 2019-11-23 14:22:36
         * goods_rank : 1
         * headimg : /uploads/2/20191127/5ddde9930592d.jpg
         * nickname : 130****4551
         * spec_key_name : 选择种类:选择10斤装 种类:礼品盒装 场景:送女友
         */

        private String content;
        private String add_time;
        private int goods_rank;
        private String headimg;
        private String nickname;
        private String spec_key_name;

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

        public int getGoods_rank() {
            return goods_rank;
        }

        public void setGoods_rank(int goods_rank) {
            this.goods_rank = goods_rank;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSpec_key_name() {
            return spec_key_name;
        }

        public void setSpec_key_name(String spec_key_name) {
            this.spec_key_name = spec_key_name;
        }
    }
}
