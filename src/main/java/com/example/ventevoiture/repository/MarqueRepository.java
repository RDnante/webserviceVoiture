package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque,Integer> {
}
