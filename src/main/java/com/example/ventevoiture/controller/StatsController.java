package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    StatsService statsService;
    @GetMapping("/nbutilisateur")
    public Etat nbutilisateur()  {
        try {
            return Etat.builder().status("ok").details("requete ok").object(statsService.get_count_utilisateur()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/nbvente")
    public Etat nbvente()  {
        try {
            return Etat.builder().status("ok").details("requete ok").object(statsService.get_count_vente()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

}
