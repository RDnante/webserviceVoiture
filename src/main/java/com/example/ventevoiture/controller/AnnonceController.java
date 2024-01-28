package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Voiture;
import com.example.ventevoiture.repository.AnnonceRepository;
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
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        annonceRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Annonce insert(@RequestBody Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Annonce update(@RequestBody Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @PostMapping("/valider/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Annonce valider(int id_annonce) {
        Annonce a = annonceRepository.findById(id_annonce).get();
        return annonceService.validation_annonce(a);
    }

    @GetMapping("/list")
    public List<Annonce> list() {
        return annonceRepository.get_list_annonce_valider();
    }

    @PostMapping("/vendu/{id}")
    @PreAuthorize("hasRole('USER')")
    public Annonce vendu(int id_annonce) {
        Annonce a = annonceRepository.findById(id_annonce).get();
        return  annonceService.vendu_annonce(a);
    }


}
