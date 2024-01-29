package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Energie;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.repository.Boite_vitesseRepository;
import com.example.ventevoiture.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boite_vitesse")
public class Boite_vitesseController {
    @Autowired
    Boite_vitesseRepository boiteVitesseRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat delete(@PathVariable int id) {
        try {
            boiteVitesseRepository.deleteById(id);
            return Etat.builder().status("ok").details("register ok").build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat insert(@RequestBody Boite_vitesse boiteVitesse) {
        try {
            return Etat.builder().status("ok").details("register ok").object(boiteVitesseRepository.save(boiteVitesse)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Boite_vitesse boiteVitesse) {
        try {
            return Etat.builder().status("ok").details("register ok").object(boiteVitesseRepository.save(boiteVitesse)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Etat list() {
        try {
            return Etat.builder().status("ok").details("register ok").object(boiteVitesseRepository.findAll()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

}
