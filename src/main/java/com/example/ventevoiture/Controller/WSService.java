package com.example.ventevoiture.Controller;

import com.example.ventevoiture.ResponseMessage;
import com.example.ventevoiture.model.Chat;
import com.example.ventevoiture.model.Message;
import com.example.ventevoiture.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class WSService {
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyFrontend(final String message){
        ResponseMessage response = new ResponseMessage(message);
        messagingTemplate.convertAndSend("/topic/messages",response);
    }

    public void notifyUser(final String id, String id_reseiver, final Message message) {
        ResponseMessage response = new ResponseMessage(message.getMessageContent());
        Chat c = new Chat();
        c.setId_sender(Integer.parseInt(id));
        c.setId_receiver(Integer.parseInt(id_reseiver));
        c.setMessage(message.getMessageContent());
        chatRepository.insert(c);
        // eto ndray ilay mi specifier hoe alefa any amin'iza ilay msg (id)
        messagingTemplate.convertAndSendToUser(id_reseiver, "/topic/private-messages", response);
    }
}
