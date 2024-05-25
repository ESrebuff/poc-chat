package com.poc.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Method to handle sending messages. It listens on the "/chat.sendMessage" endpoint.
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public") // Broadcast the return value to all subscribers of "/topic/public"
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }

    // Method to add a new user to the chat session.
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public") // Broadcast the return value to all subscribers of "/topic/public"
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add the username to the WebSocket session attributes
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
