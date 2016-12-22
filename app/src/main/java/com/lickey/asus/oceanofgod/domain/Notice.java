package com.lickey.asus.oceanofgod.domain;

import java.util.List;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/22 0:08.
 * 描述：
 * 修订历史：
 */

public class Notice {


    /**
     * result : {"msg":"接口请求成功","code":"10000"}
     * data : [{"content":"问：据报道，圣多美和普林西比政府发表声明，决定自即日起与台湾\u201c断交\u201d。中方对此有何评论？\r\n\r\n答：我们注意到圣多美和普林西比政府当地时间20日发表声明，决定同台湾断绝所谓\u201c外交\u201d关系，中方对此表示赞赏，欢迎圣普回到一个中国原则的正确轨道上来。","noticeId":1,"time":{"date":7,"day":3,"hours":10,"minutes":29,"month":11,"nanos":0,"seconds":4,"time":1481077744000,"timezoneOffset":-480,"year":116},"title":"外交部发言人华春莹就圣多美和普林西比与台湾\u201c断交\u201d答记者问","url":"www.baidu.com"},{"content":"中安在线讯据 江淮晨报消息近日，六安市裕安区政府网站发布的一条公示信息引发热议，该公示显示，一名合肥人在六安市裕安区同一个小区购买了44套房子。按照当地的补贴政策，该房主共获得约80万元补贴。\r\n\r\n目前，上述公示信息已被删除。记者昨日就此事联系到六安市裕安区房地产管理局，一工作人员称该房主票据手续齐全，并未违规。针对此事相关部门已专门开会研究处理。","noticeId":2,"time":{"date":21,"day":3,"hours":10,"minutes":32,"month":11,"nanos":0,"seconds":54,"time":1482287574000,"timezoneOffset":-480,"year":116},"title":"一合肥人在六安买了44套房 还拿了80万元购房补贴","url":"http://news.ifeng.com/a/20161221/50450671_0.shtml"}]
     */

    private ResultBean result;
    private List<DataBean> data;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ResultBean {
        /**
         * msg : 接口请求成功
         * code : 10000
         */

        private String msg;
        private String code;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static class DataBean {
        /**
         * content : 问：据报道，圣多美和普林西比政府发表声明，决定自即日起与台湾“断交”。中方对此有何评论？

         答：我们注意到圣多美和普林西比政府当地时间20日发表声明，决定同台湾断绝所谓“外交”关系，中方对此表示赞赏，欢迎圣普回到一个中国原则的正确轨道上来。
         * noticeId : 1
         * time : {"date":7,"day":3,"hours":10,"minutes":29,"month":11,"nanos":0,"seconds":4,"time":1481077744000,"timezoneOffset":-480,"year":116}
         * title : 外交部发言人华春莹就圣多美和普林西比与台湾“断交”答记者问
         * url : www.baidu.com
         */

        private String content;
        private int noticeId;
        private TimeBean time;
        private String title;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getNoticeId() {
            return noticeId;
        }

        public void setNoticeId(int noticeId) {
            this.noticeId = noticeId;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class TimeBean {
            /**
             * date : 7
             * day : 3
             * hours : 10
             * minutes : 29
             * month : 11
             * nanos : 0
             * seconds : 4
             * time : 1481077744000
             * timezoneOffset : -480
             * year : 116
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
