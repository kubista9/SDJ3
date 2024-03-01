package com.example.websocketexample.client;

import com.example.websocketexample.server.WSChatServerEndPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/test")
public class TestController {
    private WSChatServerEndPoint webSocket;

    public TestController(WSChatServerEndPoint webSocket) {
        this.webSocket = webSocket;
    }

    @GetMapping("/messages/send/{msg}")
    ResponseEntity<String> chat(@PathVariable("msg") String msg) {
        return new ResponseEntity<>(
                webSocket.send(msg),
                HttpStatus.OK);
    }
}
