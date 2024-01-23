package com.example.ventevoiture.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "marque")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_marque;
    @Column
    String libelle;
}
