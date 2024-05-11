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
    @SendTo("/topic/public") // Sends the return value of this method to the "/topic/public".
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage; // Returns the message to be broadcast to subscribed clients.
    }

    // Method to add a new user to the chat session.
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public") // Sends the return value to the "/topic/public" topic.
    public ChatMessage addUser(
        // Adds username to the WebSocket session.
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
