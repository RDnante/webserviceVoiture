package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository annonceRepository;

    public Annonce validation_annonce(Annonce annonce) {
        if (annonce.getId_status() < 5) {
            annonce.setId_status(5);
            annonceRepository.save(annonce);
        }

        return annonce;
    }

    public Annonce vendu_annonce(Annonce annonce) {
        if (annonce.getId_status() >= 5) {
            annonce.setId_status(10);
            annonceRepository.save(annonce);
        }

        return annonce;
    }
}
