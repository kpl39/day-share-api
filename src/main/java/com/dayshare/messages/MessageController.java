package com.dayshare.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepo;

    @MessageMapping("/message/{convoId}")
    @SendTo("/topic/conversations/{convoId}")
    public Message greeting(@DestinationVariable("convoId") Long convoId, Message message) throws Exception {
        messageRepo.save(message);
        System.out.println("Convo ID: " + convoId);
        System.out.println(message.getMessageText());
        return message;
    }

}
