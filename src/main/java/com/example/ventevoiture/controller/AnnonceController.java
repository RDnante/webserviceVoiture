package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Annonce_favoris;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.model.Voiture;
import com.example.ventevoiture.repository.AnnonceRepository;
import com.example.ventevoiture.repository.Annonce_favorisRepository;
import com.example.ventevoiture.repository.VoitureRepository;
import com.example.ventevoiture.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    AnnonceService annonceService;
    @Autowired
    Annonce_favorisRepository annonceFavorisRepository;

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        annonceRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat insert(@RequestBody Annonce annonce) {
        try {
            return Etat.builder().status("ok").details("update ok").object(annonceRepository.save(annonce)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Annonce annonce) {
        try {
            return Etat.builder().status("ok").details("update ok").object(annonceRepository.save(annonce)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/valider/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat valider(@PathVariable int id) {
        try {
            System.out.println("annonce "+id);
            Annonce a = annonceRepository.findById(id).get();
            return Etat.builder().status("ok").details("update ok").object(annonceService.validation_annonce(a)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/listnonvalider")
    public Etat listnonvalider() {
        try {
            List<Annonce> lista = annonceRepository.get_list_annonce_attente();
            annonceService.initialisation(lista);
            return Etat.builder().status("ok").details("register ok").object(lista).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }


    @GetMapping("/list")
    public Etat list() {
        try {
            List<Annonce> lista = annonceRepository.get_list_annonce_valider();
            annonceService.initialisation(lista);
            return Etat.builder().status("ok").details("register ok").object(lista).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/vendu/{id}")
    @PreAuthorize("hasRole('USER')")
    public Etat vendu(int id_annonce) {
        try {
            Annonce a = annonceRepository.findById(id_annonce).get();
            return Etat.builder().status("ok").details("register ok").object(annonceService.vendu_annonce(a)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/favoris")
    @PreAuthorize("hasAuthority('USER')")
    public Etat favoris(@RequestBody Annonce_favoris af) {
        try {
            return Etat.builder().status("ok").details("register ok").object(annonceFavorisRepository.save(af)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }


}
