package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Boite_vitesse;
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
    public void delete(@PathVariable int id) {
        voitureRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Voiture insert(@RequestBody Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Voiture update(@RequestBody Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Voiture> list() {
        return voitureRepository.findAll();
    }

}
