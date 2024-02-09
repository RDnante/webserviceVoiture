package com.example.ventevoiture.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "historique_annonce_complet_view")
public class Historique_annonce_complet_view {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_annonce_historique;
    @Column
    Integer id_annonce;
    Integer status;
    Date date_modification;
    Date date_annonce;
    Integer id_utilisateur;
    Integer id_voiture;

    @Transient
    Voiture voiture;
}
