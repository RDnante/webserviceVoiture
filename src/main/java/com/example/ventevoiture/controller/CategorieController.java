package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Categorie;
import com.example.ventevoiture.model.Marque;
import com.example.ventevoiture.repository.CategorieRepository;
import com.example.ventevoiture.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieRepository categorieRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        categorieRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Categorie insert(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Categorie update(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

}
