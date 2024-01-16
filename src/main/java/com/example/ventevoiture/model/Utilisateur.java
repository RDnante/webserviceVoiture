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
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idutilisateur;
    @Column(name = "nomutilisateur")
    String nomutilisateur;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "datenaissance")
    Date datenaissance;
    @Column(name = "mdputilisateur")
    String mdputilisateur;
    @Column(name = "idadmin")
    Integer isadmin;
}
