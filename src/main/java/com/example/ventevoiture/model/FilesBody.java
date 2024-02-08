package com.example.ventevoiture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FilesBody {
    Integer id_annonce;
    String files;

    public Object uploadOnline(String base64Image) {
        String key = "key=" + "API_KEY";
        try {
            String res = RequestAPI.sendFormData("URL_Server_BB" + "?" + key, base64Image);
//            JsonResponse jsonResponse = (JsonResponse) Json.fromJson(res, JsonResponse.class);

//            return jsonResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
