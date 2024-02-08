package com.example.ventevoiture.service;

import com.example.ventevoiture.Config.JwtService;
import com.example.ventevoiture.model.Employer;
import com.example.ventevoiture.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    JwtService jwtService;
    @Autowired
    EmployerRepository employerRepository;

    public Employer getempByToken(String token) {
        String email = jwtService.extractUsername(token);
        return employerRepository.findEmployerByEmail(email).get();
    }
}
