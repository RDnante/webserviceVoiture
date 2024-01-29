package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Categorie;
import com.example.ventevoiture.model.Energie;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.repository.CategorieRepository;
import com.example.ventevoiture.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energie")
public class EnergieController {
    @Autowired
    EnergieRepository energieRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat delete(@PathVariable int id) {
        try {
            energieRepository.deleteById(id);
            return Etat.builder().status("ok").details("requete ok").build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat insert(@RequestBody Energie energie) {

        try {
            return Etat.builder().status("ok").details("requete ok").object(energieRepository.save(energie)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Energie energie) {
        try {
            return Etat.builder().status("ok").details("requete ok").object(energieRepository.save(energie)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Etat list() {
        try {
            return Etat.builder().status("ok").details("requete ok").object(energieRepository.findAll()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }
}
