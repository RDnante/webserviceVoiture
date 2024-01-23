package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
