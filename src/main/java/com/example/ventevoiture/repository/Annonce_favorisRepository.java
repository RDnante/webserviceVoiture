package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Annonce_favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Annonce_favorisRepository extends JpaRepository<Annonce_favoris,Integer> {
    @Query("from annonce_favoris where id_employer = ?1")
    public List<Annonce_favoris> getAll_id_annonce_favoris(int id_employer);
}
