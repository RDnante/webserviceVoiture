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
@Entity(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_voiture;
    @Column
    String modele;
    @Column
    Integer id_marque;
    @Column
    Integer id_categorie;
    @Column
    String moteur;
    @Column
    Integer id_energie;
    @Column
    Integer id_boite_vitesse;
    @Column
    Integer puissance;
    @Column
    Double consommation;
    @Column
    String description;
    @Column
    String numero_matricule;

    @Transient
    Marque marque;
    @Transient
    Energie energie;
    @Transient
    Categorie categorie;
    @Transient
    Boite_vitesse boite_vitesse;

}
