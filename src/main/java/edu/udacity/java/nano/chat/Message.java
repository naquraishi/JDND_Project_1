package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

import java.awt.*;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.

    public static final String ENTER = "ENTER";
    public static final String CHAT = "CHAT";
    public static final String LEAVE = "LEAVE";

    private String type;
    private String username;
    private String msg;
    private int onlineCount;

    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }

    public Message(String type, String username, String msg, int onlineCount) {
        this.type = type;
        this.username = username;
        this.msg = msg;
        this.onlineCount = onlineCount;
    }


    public String getType() {
        return type;
    }


    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }

    public int getOnlineCount() {
        return onlineCount;
    }


    }