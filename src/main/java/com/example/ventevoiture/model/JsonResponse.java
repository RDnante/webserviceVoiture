package com.example.ventevoiture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponse {
    Annonce annonce;
    Object object;

    int id;
    String token;
//    public static class Image {
//        private String filename;
//        private String name;
//        private String mime;
//        private String extension;
//        private String url;
//
//        // Ajoutez les getters et les setters
//    }
}
