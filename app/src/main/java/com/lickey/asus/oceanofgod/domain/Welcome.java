package com.lickey.asus.oceanofgod.domain;

import java.util.List;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/21 21:56.
 * 描述：欢迎页
 * 修订历史：
 */

public class Welcome {


    /**
     * result : {"msg":"接口请求成功","code":"10000"}
     * data : {"welcome":[{"img":"http://api.am81188.com/image/screen.jpg","url":"www.baidu.com","welcomeId":1}]}
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
        private List<WelcomeBean> welcome;

        public List<WelcomeBean> getWelcome() {
            return welcome;
        }

        public void setWelcome(List<WelcomeBean> welcome) {
            this.welcome = welcome;
        }

        public static class WelcomeBean {
            /**
             * img : http://api.am81188.com/image/screen.jpg
             * url : www.baidu.com
             * welcomeId : 1
             */

            private String img;
            private String url;
            private int welcomeId;

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

            public int getWelcomeId() {
                return welcomeId;
            }

            public void setWelcomeId(int welcomeId) {
                this.welcomeId = welcomeId;
            }
        }
    }
}
