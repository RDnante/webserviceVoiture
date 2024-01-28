package com.example.ventevoiture.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "annonce_favoris")
public class Annonce_favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_annonce_favoris;

    Integer id_employer;
    Integer id_annonce;
    Date date;
}
