package com.hqf.uibestpractice;

public class Msg {
    public static final int TYPE_RECEIVED = 0;//接受
    public static final int TYPE_SENT = 1;//发送
    private String content;//消息
    private int type;//类型（接受/发送）

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
