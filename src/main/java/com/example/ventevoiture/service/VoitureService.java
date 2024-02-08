package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Voiture;
import com.example.ventevoiture.repository.Boite_vitesseRepository;
import com.example.ventevoiture.repository.CategorieRepository;
import com.example.ventevoiture.repository.EnergieRepository;
import com.example.ventevoiture.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {
    @Autowired
    MarqueRepository marqueRepository;
    @Autowired
    EnergieRepository energieRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    Boite_vitesseRepository boiteVitesseRepository;

    public void initVoiture(Voiture voiture) {
        voiture.setMarque(marqueRepository.findById(voiture.getId_marque()).get());
        voiture.setEnergie(energieRepository.findById(voiture.getId_energie()).get());
        voiture.setCategorie(categorieRepository.findById(voiture.getId_categorie()).get());
        voiture.setBoite_vitesse(boiteVitesseRepository.findById(voiture.getId_boite_vitesse()).get());
    }
}
