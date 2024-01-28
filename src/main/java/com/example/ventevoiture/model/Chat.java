package com.example.ventevoiture.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "chat")
public class Chat {
    @Id
    String id_chat;
    int id_sender;
    int id_receiver;
    String message;
    public String getId_chat() {
        return id_chat;
    }
    public void setId_chat(String id_chat) {
        this.id_chat = id_chat;
    }
    public int getId_sender() {
        return id_sender;
    }
    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }
    public int getId_receiver() {
        return id_receiver;
    }
    public void setId_receiver(int id_receiver) {
        this.id_receiver = id_receiver;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
