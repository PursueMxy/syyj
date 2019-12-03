package com.zhkj.syyj.Beans;

public class UploadBean {

    /**
     * code : 1
     * msg : 上传成功
     * time : 1573191010
     * data : {"path":"/uploads/app/20191108/5dc4fd6247b52.jpg"}
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
         * path : /uploads/app/20191108/5dc4fd6247b52.jpg
         */

        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
