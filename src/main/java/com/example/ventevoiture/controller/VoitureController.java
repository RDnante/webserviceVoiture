package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.model.Voiture;
import com.example.ventevoiture.repository.Boite_vitesseRepository;
import com.example.ventevoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voiture")
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat delete(@PathVariable int id) {

        try {
            voitureRepository.deleteById(id);
            return Etat.builder().status("ok").details("requete ok").build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PutMapping("/insert")
    public Etat insert(@RequestBody Voiture voiture) {
        try {
            return Etat.builder().status("ok").details("requete ok").object(voitureRepository.save(voiture)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Voiture voiture) {
        try {
            return Etat.builder().status("ok").details("requete ok").object(voitureRepository.save(voiture)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Etat list() {
        try {
            return Etat.builder().status("ok").details("requete ok").object(voitureRepository.findAll()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

}
