package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
