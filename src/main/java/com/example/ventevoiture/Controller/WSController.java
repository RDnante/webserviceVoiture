package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {
    @Autowired
    private WSService service;
//    @Autowired
//    private UtilisateursRepository utilisateursRepository;


    @PostMapping("/send-message/{id}/{id2}")
    public void sendMessage(@PathVariable final String id,@PathVariable final String id2,@RequestBody final Message message){
        System.out.println(message.getMessageContent());
        System.out.println("huhu");
//        System.out.println(utilisateursRepository.findAll().get(0));
        // service.notifyFrontend(message.getMessageContent());
        service.notifyUser(id,id2, message);
    }
}
