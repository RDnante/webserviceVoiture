package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Historique_annonce_complet_view;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Historique_annonce_completRepository extends JpaRepository<Historique_annonce_complet_view,Integer> {
}
