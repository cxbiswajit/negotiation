package net.openprice.service.negotiation.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import net.openprice.service.negotiation.model.ChatMessage;

@Controller
public class ChatController {
    @MessageMapping("/chat/{userId}")
    @SendToUser("/queue/messages") // Send the response to the user-specific message queue
    public ChatMessage sendMessage(@DestinationVariable String userId, ChatMessage message) {
        // Process the received message (e.g., chatbot logic) and create a response
        ChatMessage response = new ChatMessage("Chatbot", "Hello, " + message.getSender() + "! How can I assist you?");
        return response;
    }
}
