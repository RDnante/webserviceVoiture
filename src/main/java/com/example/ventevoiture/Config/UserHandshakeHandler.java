package com.example.ventevoiture.Config;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import com.sun.security.auth.*;


/**
 * UserHandshakeHandler
 */
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
            Map<String, Object> attributes) {
                String[] url = request.getURI().toString().split("id_user=");
                String id = url[1];

                // final String randomId = UUID.randomUUID().toString();
                if (id.contains("&")) {
                    id = id.split("&")[0];
                }
                LOG.info("User with ID '{}' opened the page", id);
        // TODO Auto-generated method stub
        return new UserPrincipal(id);
    }

}