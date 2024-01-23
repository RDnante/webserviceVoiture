package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer,Integer> {
    Optional<Employer> findEmployerById(Long id);

    Optional<Employer> findEmployerByEmail(String email);
}
