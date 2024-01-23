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
@Entity(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_annonce;
    @Column
    Date date_annonce;
    @Column
    Integer id_utilisateur;
    @Column
    Integer id_voiture;
    @Column
    Double prix;
    @Column
    Integer id_status;
}
