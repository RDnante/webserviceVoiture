package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat,String> {

    @Query("{'id_sender' : ?1}")
    public List<Chat> getChatByIdSender(int id_sender);

    @Query("{'id_receiver' : ?1}")
    public List<Chat> getChatByIdReceiver(int id_receiver);
}
