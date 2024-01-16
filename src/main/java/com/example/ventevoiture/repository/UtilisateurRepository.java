package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

}
