package com.example.ventevoiture.service;

import com.example.ventevoiture.model.Annonce;
import com.example.ventevoiture.model.Historique_annonce;
import com.example.ventevoiture.model.Historique_annonce_complet_view;
import com.example.ventevoiture.repository.Historique_annonceRepository;
import com.example.ventevoiture.repository.Historique_annonce_completRepository;
import com.example.ventevoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class HistoriqueService {
    @Autowired
    Historique_annonceRepository historiqueAnnonceRepository;
    @Autowired
    Historique_annonce_completRepository historiqueAnnonceCompletRepository;
    @Autowired
    VoitureRepository voitureRepository;


    public void engHistorique(Annonce annonce) {
        Historique_annonce annonce1 = new Historique_annonce();
        annonce1.setId_annonce(annonce.getId_annonce());
        annonce1.setStatus(annonce.getId_status());
        annonce1.setDate_modification(Date.valueOf(LocalDate.now()));

        historiqueAnnonceRepository.save(annonce1);
    }
    public void Initialisation(Historique_annonce_complet_view hac) {
        hac.setVoiture(voitureRepository.findById(hac.getId_voiture()).get());
    }

    public void Initialisation(List<Historique_annonce_complet_view> list) {
        for (Historique_annonce_complet_view a : list) {
            this.Initialisation(a);
        }
    }
}
