package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
}
