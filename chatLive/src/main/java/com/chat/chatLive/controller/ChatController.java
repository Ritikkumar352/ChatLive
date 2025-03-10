package com.chat.chatLive.controller;


import com.chat.chatLive.model.MessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public MessageModel register(@Payload MessageModel message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());

        return message;   // --- ??
    }

    //  -- ??

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public MessageModel chat(@Payload MessageModel message) {
        return message;
    }

}
