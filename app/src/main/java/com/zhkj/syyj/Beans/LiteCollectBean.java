package com.zhkj.syyj.Beans;

import org.litepal.crud.LitePalSupport;

public class LiteCollectBean extends LitePalSupport {

    private int collect_id;
    private int goods_id;
    private String goods_name;
    private String shop_price;
    private String original_img;
    private String collect_slt;
    private String IsShow;

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
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

    public String getCollect_slt() {
        return collect_slt;
    }

    public void setCollect_slt(String collect_slt) {
        this.collect_slt = collect_slt;
    }

    public String getIsShow() {
        return IsShow;
    }

    public void setIsShow(String isShow) {
        IsShow = isShow;
    }

    public LiteCollectBean() {
    }
}
