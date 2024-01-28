package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Marque;
import com.example.ventevoiture.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marque")
public class MarqueController {
    @Autowired
    MarqueRepository marqueRepository;
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        marqueRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Marque insert(@RequestBody Marque marque) {
        return marqueRepository.save(marque);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Marque update(@RequestBody Marque marque) {
        return marqueRepository.save(marque);
    }

}
