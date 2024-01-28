package com.example.ventevoiture.Controller;


import java.security.Principal;

import com.example.ventevoiture.ResponseMessage;
import com.example.ventevoiture.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

//    @Autowired
//    private UtilisateursRepository utilisateursRepository;
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final Message message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("atooooooo");
//        System.out.println(utilisateursRepository.findAll().get(0).getNom());
        return  new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public ResponseMessage getPrivateMessage(final Message message, final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("atooooooo");
        return  new ResponseMessage(HtmlUtils.htmlEscape("Sending private message to user "+principal.getName()+": "+message.getMessageContent()));
    }
}
