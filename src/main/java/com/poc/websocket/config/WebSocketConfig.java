package com.poc.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register a WebSocket endpoint that clients will use to connect to the WebSocket server
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Configure message broker
        // Set the prefix for messages bound for methods annotated with @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");
        // Enable a simple in-memory broker for messages with destinations prefixed with /topic
        registry.enableSimpleBroker("/topic");
    }
}
