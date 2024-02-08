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
@Entity(name = "photos_annonce")
public class Photos_annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_photo_annonce;
    @Column
    Integer id_annonce;
    @Column
    String url;
}
