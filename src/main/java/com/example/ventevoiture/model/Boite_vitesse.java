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
@Entity(name = "boite_vitesse")
public class Boite_vitesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_boite_vitesse;
    @Column
    String libelle;
}
