package com.example.ventevoiture.controller;

import com.example.ventevoiture.Config.JwtService;
import com.example.ventevoiture.model.Employer;
import com.example.ventevoiture.repository.EmployerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    JwtService jwtService;
    @GetMapping("/utilisateur")
    public List<Employer> getallemployer() {

        return employerRepository.findAll();
    }

    @GetMapping("/count")
    public int getcount() {
        return employerRepository.count_utilisateur();
    }

    @GetMapping("/dateexp")
    public Date getdate() {
        return jwtService.extractExpiration("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZWFuQGdtYWlsLmNvbSIsImlhdCI6MTcwNjUzNTc0NywiZXhwIjoxNzA2OTY3NzQ3fQ.i-4OK2AJgMQid4Klr83i2MLu52eTohcj5aiwlTpgXtA");
    }
}
