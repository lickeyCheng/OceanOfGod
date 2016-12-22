package com.lickey.asus.oceanofgod.domain;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/22 0:34.
 * 描述：
 * 修订历史：
 */

public class Message {

    private long time;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Message(String content, long time) {
        this.content = content;
        this.time = time;
    }
}
