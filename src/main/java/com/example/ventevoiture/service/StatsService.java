package com.example.ventevoiture.service;

import com.example.ventevoiture.repository.AnnonceRepository;
import com.example.ventevoiture.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    EmployerRepository employerRepository;

    //maka isanah vente rehetra
    public int get_count_vente() {
        return annonceRepository.get_count_vente();
    }

    // maka nombre d'utilisateur
    public int get_count_utilisateur() {
        return employerRepository.count_utilisateur();
    }
}
