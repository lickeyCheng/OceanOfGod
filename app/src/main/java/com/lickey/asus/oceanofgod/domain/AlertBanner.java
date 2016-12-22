package com.lickey.asus.oceanofgod.domain;

import java.util.List;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/21 22:49.
 * 描述：首页弹框
 * 修订历史：
 */

public class AlertBanner {


    /**
     * result : {"msg":"接口请求成功","code":"10000"}
     * data : {"banner":[{"alertId":1,"img":"http:\\/\\/api.am81188.com\\/image\\/375.png","url":"www.baidu.com"}]}
     */

    private ResultBean result;
    private DataBean data;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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
        private List<BannerBean> banner;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class BannerBean {
            /**
             * alertId : 1
             * img : http:\/\/api.am81188.com\/image\/375.png
             * url : www.baidu.com
             */

            private int alertId;
            private String img;
            private String url;

            public int getAlertId() {
                return alertId;
            }

            public void setAlertId(int alertId) {
                this.alertId = alertId;
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
    }
}
