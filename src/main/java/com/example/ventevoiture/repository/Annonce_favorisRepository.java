package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Annonce_favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Annonce_favorisRepository extends JpaRepository<Annonce_favoris,Integer> {
}
