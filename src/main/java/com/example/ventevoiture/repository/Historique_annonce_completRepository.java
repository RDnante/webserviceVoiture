package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Historique_annonce_complet_view;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Historique_annonce_completRepository extends JpaRepository<Historique_annonce_complet_view,Integer> {
    @Query("from historique_annonce_complet_view where id_utilisateur = ?1")
    public List<Historique_annonce_complet_view> getHistoriqueByUser(int id_utilisateur);
}
