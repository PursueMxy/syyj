package com.zhkj.syyj.Beans;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class LiteGoodsCartBean extends LitePalSupport {
    private int  goods_cart_id;
    private int goods_id;
    private String goods_name;
    private String goods_price;
    private int goods_num;
    private int item_id;
    private String spec_key_name;
    private int selected;
    private String original_img;
    private String slt_goods;

    public int getGoods_cart_id() {
        return goods_cart_id;
    }

    public void setGoods_cart_id(int goods_cart_id) {
        this.goods_cart_id = goods_cart_id;
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

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getSpec_key_name() {
        return spec_key_name;
    }

    public void setSpec_key_name(String spec_key_name) {
        this.spec_key_name = spec_key_name;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public String getOriginal_img() {
        return original_img;
    }

    public void setOriginal_img(String original_img) {
        this.original_img = original_img;
    }

    public String getSlt_goods() {
        return slt_goods;
    }

    public void setSlt_goods(String slt_goods) {
        this.slt_goods = slt_goods;
    }

    public LiteGoodsCartBean() {
    }

    public LiteGoodsCartBean(int goods_cart_id, int goods_id, String goods_name, String goods_price, int goods_num, int item_id, String spec_key_name, int selected, String original_img, String slt_goods) {
        this.goods_cart_id = goods_cart_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_num = goods_num;
        this.item_id = item_id;
        this.spec_key_name = spec_key_name;
        this.selected = selected;
        this.original_img = original_img;
        this.slt_goods = slt_goods;
    }
}
