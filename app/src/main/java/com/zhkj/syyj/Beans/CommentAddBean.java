package com.zhkj.syyj.Beans;

public class CommentAddBean {
    private int goods_id;

    private String goods_rank;

    private String content;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_rank() {
        return goods_rank;
    }

    public void setGoods_rank(String goods_rank) {
        this.goods_rank = goods_rank;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentAddBean() {
    }

    public CommentAddBean(int goods_id, String goods_rank, String content) {
        this.goods_id = goods_id;
        this.goods_rank = goods_rank;
        this.content = content;
    }
}
