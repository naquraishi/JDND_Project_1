package edu.udacity.java.nano.chat;

import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static java.lang.String.format;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint(value="/chat")

public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();


    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        //TODO: add on open connection.
        onlineSessions.put(username, session);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        //TODO: add send message.
        sendMessageToAll(message);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
        System.out.println(format("%s left the chat room.", session.getId()));
        onlineSessions.remove(session.getId());
        Message message = new Message();
        message.setMsg("Disconnected");
        sendMessageToAll(message.getMsg());
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    private static void sendMessageToAll(String msg) {
        onlineSessions.forEach((id, session) -> {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
