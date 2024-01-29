package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Annonce_favoris;
import com.example.ventevoiture.repository.AnnonceRepository;
import com.example.ventevoiture.repository.Annonce_favorisRepository;
import com.example.ventevoiture.repository.EmployerRepository;
import com.example.ventevoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        }
    }
}
