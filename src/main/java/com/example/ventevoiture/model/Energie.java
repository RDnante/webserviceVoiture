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
@Entity(name = "energie")
public class Energie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_energie;
    @Column
    String libelle;
}
