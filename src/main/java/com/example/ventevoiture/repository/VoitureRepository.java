package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
    @Query("select  max(id_voiture) from  voiture ")
    public int getLastId_voiture();
}
