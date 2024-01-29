package com.example.ventevoiture.Auth;

import com.example.ventevoiture.model.Etat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService service;
    
    @PostMapping("/register")
    public Etat register(@RequestBody RegisterRequest request){
        try {
            return Etat.builder()
                    .status("ok")
                    .details("register ok")
                    .object(service.register(request))
                    .build();
        }catch (Exception e) {
            return Etat.builder()
                    .status("erreur")
                    .details(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/authenticate")
    public Etat authenticate(@RequestBody AuthenticationRequest request){
        try {
            return Etat.builder()
                    .status("ok")
                    .details("connecter")
                    .object(service.authenticate(request))
                    .build();
        } catch (Exception e) {
            return Etat.builder()
                    .status("erreur")
                    .details(e.getMessage())
                    .build();
        }
    }
}
