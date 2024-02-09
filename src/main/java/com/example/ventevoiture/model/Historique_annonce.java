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
@Entity(name = "historique_annonce")
public class Historique_annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_historique_annonce;
    @Column
    Integer id_annonce;
    @Column
    Integer status;
    @Column
    Date date_modification;
}
