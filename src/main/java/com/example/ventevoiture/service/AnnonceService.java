package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Annonce_favoris;
import com.example.ventevoiture.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    Annonce_favorisRepository annonceFavorisRepository;
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    Photos_annonceRepository photosAnnonceRepository;
    @Autowired
    VoitureService voitureService;

    // fonction mi-valider annonce
    public Annonce validation_annonce(Annonce annonce) {
        if (annonce.getId_status() < 5) {
            annonce.setId_status(5);
            annonceRepository.save(annonce);
        }

        return annonce;
    }

    // fonction mamadika annonce ho vendu
    public Annonce vendu_annonce(Annonce annonce) {
        if (annonce.getId_status() >= 5) {
            annonce.setId_status(10);
            annonceRepository.save(annonce);
        }

        return annonce;
    }

    // mettre en favoris un annonce
    public Annonce set_favoris_annonce(Annonce annonce,int id_utilisateur) {
        annonceFavorisRepository.save(Annonce_favoris.builder()
                .id_annonce(annonce.getId_annonce())
                .id_employer(id_utilisateur)
                .build());

        return annonce;
    }

    // prendre l'historique de ses annonces
    public List<Annonce> get_annonce_by_utilisateur(int id_utilisateur) {
        return annonceRepository.get_list_annonce_byIdUser(id_utilisateur);
    }

    public void initialisation(List<Annonce> list) {
        for (Annonce a : list) {
            a.setVoiture(voitureRepository.findById(a.getId_voiture()).get());
            a.setEmployer(employerRepository.findById(a.getId_utilisateur()).get());
            a.setPhotos(photosAnnonceRepository.getAllPhoto(a.getId_annonce()));
            voitureService.initVoiture(a.getVoiture());
        }
    }

    public void initialisation(Annonce a) {
//        for (Annonce a : list) {
            a.setVoiture(voitureRepository.findById(a.getId_voiture()).get());
            a.setEmployer(employerRepository.findById(a.getId_utilisateur()).get());
            a.setPhotos(photosAnnonceRepository.getAllPhoto(a.getId_annonce()));
            voitureService.initVoiture(a.getVoiture());
//        }
    }

    // maka ny liste annonce favoris par utilisateur
    public List<Annonce> getFavorisByUsers(int id_user) {
        List<Annonce_favoris> annonceFavorisList = annonceFavorisRepository.getAll_id_annonce_favoris(id_user);
        List<Annonce> valiny = new ArrayList<>();
        for (Annonce_favoris af : annonceFavorisList) {
            valiny.add(annonceRepository.findById(af.getId_annonce()).get());
        }

        this.initialisation(valiny);

        return valiny;
    }
}
