package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Categorie;
import com.example.ventevoiture.model.Etat;
import com.example.ventevoiture.model.Marque;
import com.example.ventevoiture.repository.CategorieRepository;
import com.example.ventevoiture.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    CategorieRepository categorieRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat delete(@PathVariable int id) {
        try {
            categorieRepository.deleteById(id);
            return Etat.builder().status("ok").details("requete ok").build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/insert")
    public Etat insert(@RequestBody Categorie categorie) {
        try {
            return Etat.builder().status("ok").details("requete ok").object(categorieRepository.save(categorie)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Categorie categorie) {
        try {
            return Etat.builder().status("ok").details("requete ok").object(categorieRepository.save(categorie)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Etat list() {

        try {
            return Etat.builder().status("ok").details("requete ok").object(categorieRepository.findAll()).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }
}
