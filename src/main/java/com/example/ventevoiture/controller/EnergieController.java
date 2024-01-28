package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
import com.example.ventevoiture.model.Categorie;
import com.example.ventevoiture.model.Energie;
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
    public void delete(@PathVariable int id) {
        energieRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Energie insert(@RequestBody Energie energie) {
        return energieRepository.save(energie);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Energie update(@RequestBody Energie energie) {
        return energieRepository.save(energie);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Energie> list() {
        return energieRepository.findAll();
    }
}
