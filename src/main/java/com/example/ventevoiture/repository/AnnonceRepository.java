package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
    @Query("from annonce where id_status >= 5")
    public List<Annonce> get_list_annonce_valider();
}
