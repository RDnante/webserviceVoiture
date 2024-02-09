package com.example.ventevoiture.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recherche {
    private String motCle;
    private Date date;
    private int idCategorie;
    private double prixMin;
    private double prixMax;
    private int idMarque;
    private int idEnergie;
    private int idBoiteVitesse;
    private double consoMin;
    private double consoMax;
}
