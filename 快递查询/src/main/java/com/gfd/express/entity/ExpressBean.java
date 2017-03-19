package com.gfd.express.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述：
 * 作者：郭富东
 * 创建日期： 2017/3/17 0017 下午 5:06
 * 更新日期：
 */
public class ExpressBean implements Serializable{


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
    public List<DataEntity> data;

    public static class DataEntity implements Serializable{
        /**
         * time : 2016-11-26 19:10:30
         * ftime : 2016-11-26 19:10:30
         * context : 客户 签收人 : 本人签收 已签收  感谢使用圆通速递，期待再次为您服务
         * location : null
         */

        public String time;
        public String ftime;
        public String context;
        public Object location;
    }
}
