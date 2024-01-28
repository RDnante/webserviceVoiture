package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.Employer;
import com.example.ventevoiture.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    EmployerRepository employerRepository;
    @GetMapping("/utilisateur")
    public List<Employer> getallemployer() {

        return employerRepository.findAll();
    }

    @GetMapping("/count")
    public int getcount() {
        return employerRepository.count_utilisateur();
    }
}
