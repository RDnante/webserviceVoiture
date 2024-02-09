package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Employer;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.model.Historique_annonce_complet_view;
import com.example.ventevoiture.model.JsonResponse;
import com.example.ventevoiture.repository.Historique_annonce_completRepository;
import com.example.ventevoiture.service.HistoriqueService;
import com.example.ventevoiture.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique")
public class HistoriqueController {
    @Autowired
    Historique_annonce_completRepository historiqueAnnonceCompletRepository;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    HistoriqueService historiqueService;

    @PostMapping("/list")
    public Etat list(@RequestBody JsonResponse jsonResponse) {
        try {
            Employer e = utilisateurService.getempByToken(jsonResponse.getToken());
            List<Historique_annonce_complet_view> valiny = historiqueAnnonceCompletRepository.getHistoriqueByUser(e.getId().intValue());
            historiqueService.Initialisation(valiny);

            return Etat.builder().status("ok").details("requete ok").object(valiny).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }
}
