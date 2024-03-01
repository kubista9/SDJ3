package com.example.websocketexample.server;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ServerEndpoint("/websocket/chat")
public class WSChatServerEndPoint {
    private static Logger LOG = LoggerFactory.getLogger(WSChatServerEndPoint.class);

    @OnOpen
    public void onOpen() {
        LOG.info(" ### Connected ... " );
    }

    @OnMessage
    public String onMessage(String message){
        LOG.info("Message: " + message);
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String resp = String.format("From Server [ %s (%s) ]", message, time);
        return resp;
    }

    @OnClose
    public void onClose() {
        LOG.info("### Connection closed ");
    }

    public String send(String message){
        LOG.info("### Message: " + message);
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return "### From Server [" + message + time + "]";
    }
}
