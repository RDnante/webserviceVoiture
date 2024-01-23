package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Energie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergieRepository extends JpaRepository<Energie,Integer> {
}
