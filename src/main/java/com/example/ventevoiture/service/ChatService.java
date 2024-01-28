package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Chat;
import com.example.ventevoiture.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService{
    @Autowired
    ChatRepository chatRepository;

    public void insertion(int id_send, int id_receive, String message){
        Chat c = new Chat();
        c.setId_sender(id_send);
        c.setId_receiver(id_receive);
        c.setMessage(message);
        chatRepository.insert(c);
    }

    public List<Chat> getAllChatByIdSender(int id){
        return chatRepository.getChatByIdSender(id);
    }

    public List<Chat> getAllChatByIdReceiver(int id){
        return chatRepository.getChatByIdReceiver(id);
    }
}
