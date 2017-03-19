package com.example.administrator.mycheckdemo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class Model implements Serializable {

    /**
     * message : ok
     * nu : 2234014274
     * ischeck : 1
     * condition : F00
     * com : yuantong
     * status : 200
     * state : 3
     * data : [{"time":"2016-11-26 19:10:30","ftime":"2016-11-26 19:10:30","context":"客户 签收人 : 本人签收 已签收  感谢使用圆通速递，期待再次为您服务","location":null},{"time":"2016-11-22 18:19:03","ftime":"2016-11-22 18:19:03","context":"派送不成功，政府机关、学校等特殊单位，正在安排处理中。","location":null},{"time":"2016-11-22 14:20:50","ftime":"2016-11-22 14:20:50","context":"北京大学 已签收","location":null},{"time":"2016-11-22 10:33:25","ftime":"2016-11-22 10:33:25","context":"北京七道堰 已发出,下一站 北京大学","location":null},{"time":"2016-11-22 10:27:47","ftime":"2016-11-22 10:27:47","context":"北京六和塔 已收入","location":null},{"time":"2016-11-22 16:53:18","ftime":"2016-11-22 16:53:18","context":"浙江省五道口 已发出,下一站 北京转运中心","location":null},{"time":"2016-11-22 00:33:51","ftime":"2016-11-22 00:33:51","context":"浙江省四码头 已收入","location":null},{"time":"2016-11-11 23:53:09","ftime":"2016-11-11 23:53:09","context":"浙江省三里屯 已发出,下一站 浙江省金华市义乌市","location":null},{"time":"2016-11-11 20:04:10","ftime":"2016-11-11 20:04:10","context":"浙江省二亩地 已打包","location":null},{"time":"2016-11-1 18:11:16","ftime":"2016-11-11 18:11:16","context":"浙江省一条街 已揽收","location":null}]
     */

    public String message;
    public String nu;
    public String ischeck;
    public String condition;
    public String com;
    public String status;
    public String state;
    public List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * time : 2016-11-26 19:10:30
         * ftime : 2016-11-26 19:10:30
         * context : 客户 签收人 : 本人签收 已签收  感谢使用圆通速递，期待再次为您服务
         * location : null
         */

        private String time;
        private String ftime;
        private String context;
        private Object location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getFtime() {
            return ftime;
        }

        public void setFtime(String ftime) {
            this.ftime = ftime;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }
    }
}
