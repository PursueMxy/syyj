package com.zhkj.syyj.Utils;

import java.util.ArrayList;
import java.util.List;

//我的订单列表数据封装
public class MultipleTypeDataHelper {
    public List<MultipleTypeData> datas = new ArrayList<MultipleTypeData>();//二次封装的数据容器

    public void add(MultipleTypeData multipleTypeData){
        datas.add(multipleTypeData);
    }

    public void remove(MultipleTypeData multipleTypeData){
        datas.remove(multipleTypeData);
    }

    public void remove(int index){
        datas.remove(index);
    }


    /**
     * 添加不同类型的数据
     * @param type 数据类型
     * @param object 对应数据
     */
    public void add(int type, Object object){
        MultipleTypeData multipleTypeData = new MultipleTypeData();
        multipleTypeData.setData(object);
        multipleTypeData.setType(type);
        add(multipleTypeData);
    }

    public List<MultipleTypeData> getDatas() {
        return datas;
    }

    public void setDatas(List<MultipleTypeData> datas) {
        this.datas = datas;
    }

    class MultipleTypeData{
        private int type;//自行定好 type值对应的类型
        private Object data;//数据 大items数据  或小item数据

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
