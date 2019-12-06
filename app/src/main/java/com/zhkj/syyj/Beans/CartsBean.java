package com.zhkj.syyj.Beans;

public class CartsBean {
    private int id;
    private int goods_num;
    private int selected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public CartsBean() {
    }

    public CartsBean(int id, int goods_num, int selected) {
        this.id = id;
        this.goods_num = goods_num;
        this.selected = selected;
    }
}
