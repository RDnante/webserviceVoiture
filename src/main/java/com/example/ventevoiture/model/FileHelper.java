package com.example.ventevoiture.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileHelper {

    public Object   uploadOnline(String base64Image,Integer id_annonce) {
        String key = "key=" + "d0efac0b2fcc05496e0a7d217c3f146b";
        try {
            String res = RequestAPI.sendFormData("https://api.imgbb.com/1/upload" + "?" + key, base64Image);
            System.out.println(res);
            ObjectMapper o = new ObjectMapper();

            JsonNode jsonNode = o.readTree(res);

            String displayUrl = jsonNode.path("data").path("display_url").asText();
//            System.out.println("display_url: " + displayUrl);
            Photos_annonce response = new Photos_annonce();
            response.setUrl(displayUrl);
            response.setId_annonce(id_annonce);
//            JsonResponse jsonResponse = (JsonResponse) o.readValue(res,JsonResponse.class);
//                    Json.fromJson(res, );

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
