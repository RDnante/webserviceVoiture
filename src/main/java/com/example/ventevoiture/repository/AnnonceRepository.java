package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
}
