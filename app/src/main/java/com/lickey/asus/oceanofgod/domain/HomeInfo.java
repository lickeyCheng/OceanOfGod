package com.lickey.asus.oceanofgod.domain;

import java.util.List;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/20 15:52.
 * 描述：首页
 * 修订历史：
 */

public class HomeInfo {


    /**
     * succeed : 1
     * msg : http://api.am81188.com/msg.php
     * banner : [{"bannerId":1,"img":"http://api.am81188.com/upfiles/standard/201612/1480663282040.jpg","url":"http://ww-0788.com/wap/huoding.html"},{"bannerId":2,"img":"http://api.am81188.com/upfiles/standard/201612/1480662873166.jpg","url":"http://ww-0788.com/wap/huoding.html"},{"bannerId":3,"img":"http://api.am81188.com/upfiles/standard/201612/1480658017291.jpg","url":"http://ww-0788.com/wap/huoding.html"},{"bannerId":4,"img":"http://api.am81188.com/upfiles/standard/201612/1480658044895.jpg","url":"http://ww-0788.com/wap/huoding.html"}]
     * list : [[{"type":1,"url":"http://www.2a0788.com","urlId":1},{"type":1,"url":"http://www.3a0788.com","urlId":2},{"type":1,"url":"http://www.8a0788.com","urlId":3},{"type":1,"url":"http://www.63166.com","urlId":4}],[{"type":2,"url":"http://tieba.baidu.com/f?kw=t%e8%b1%86%e5%a8%b1%e4%b9%90%e5%9f%8e","urlId":5},{"type":2,"url":"http://tieba.baidu.com/f?kw=%e5%bd%a9%e7%a5%a8","urlId":6}]]
     * login : ["备用网址","简易网址"]
     * register : http://www.88a788.com/?aff=591740
     * notice : ["手机登录：5788.cc下载APP，随时畅玩澳门赌场\\n","登录bbin客户端，账号登录后置码：@788\\n"]
     * ping : http://api.am81188.com/ping.php
     * youhui : http://ww-0788.com/wap/huoding.html
     */

    private int succeed;
    private String msg;
    private String register;
    private String ping;
    private String youhui;
    private List<BannerBean> banner;
    private List<List<ListBean>> list;
    private List<String> login;
    private List<String> notice;

    public int getSucceed() {
        return succeed;
    }

    public void setSucceed(int succeed) {
        this.succeed = succeed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }

    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<List<ListBean>> getList() {
        return list;
    }

    public void setList(List<List<ListBean>> list) {
        this.list = list;
    }

    public List<String> getLogin() {
        return login;
    }

    public void setLogin(List<String> login) {
        this.login = login;
    }

    public List<String> getNotice() {
        return notice;
    }

    public void setNotice(List<String> notice) {
        this.notice = notice;
    }

    public static class BannerBean {
        /**
         * bannerId : 1
         * img : http://api.am81188.com/upfiles/standard/201612/1480663282040.jpg
         * url : http://ww-0788.com/wap/huoding.html
         */

        private int bannerId;
        private String img;
        private String url;

        public int getBannerId() {
            return bannerId;
        }

        public void setBannerId(int bannerId) {
            this.bannerId = bannerId;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ListBean {
        /**
         * type : 1
         * url : http://www.2a0788.com
         * urlId : 1
         */

        private int type;
        private String url;
        private int urlId;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUrlId() {
            return urlId;
        }

        public void setUrlId(int urlId) {
            this.urlId = urlId;
        }
    }
}
