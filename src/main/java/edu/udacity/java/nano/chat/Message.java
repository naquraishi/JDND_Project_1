package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

import java.awt.*;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.

    private String msg;
    private String username;
    private int onlineCount;


    public Message() {

    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}