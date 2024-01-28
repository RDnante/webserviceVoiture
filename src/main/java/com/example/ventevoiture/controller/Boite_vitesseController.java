package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Energie;
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
    public void delete(@PathVariable int id) {
        boiteVitesseRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Boite_vitesse insert(@RequestBody Boite_vitesse boiteVitesse) {
        return boiteVitesseRepository.save(boiteVitesse);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Boite_vitesse update(@RequestBody Boite_vitesse boiteVitesse) {
        return boiteVitesseRepository.save(boiteVitesse);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Boite_vitesse> list() {
        return boiteVitesseRepository.findAll();
    }

}
