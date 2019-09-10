package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

import java.awt.*;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.

    public static final String ENTER = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    private String username;
    private String msg;
    private int onlineCount;

    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }

    public Message(String type, String username, String msg, int onlineCount) {
        this.username = username;
        this.msg = msg;
        this.onlineCount = onlineCount;
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