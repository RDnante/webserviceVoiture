package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Photos_annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Photos_annonceRepository extends JpaRepository<Photos_annonce,Integer> {
    @Query("from photos_annonce where id_annonce = ?1")
    List<Photos_annonce> getAllPhoto(Integer id_annonce);
}
