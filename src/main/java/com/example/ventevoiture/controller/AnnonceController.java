package com.example.ventevoiture.controller;

import com.example.ventevoiture.Config.JwtService;
import com.example.ventevoiture.model.*;
import com.example.ventevoiture.repository.*;
import com.example.ventevoiture.service.AnnonceService;
import com.example.ventevoiture.service.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.security.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    AnnonceService annonceService;
    @Autowired
    Annonce_favorisRepository annonceFavorisRepository;
    @Autowired
    Photos_annonceRepository photosAnnonceRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    UtilisateurService utilisateurService;

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        annonceRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat insert(@RequestBody JsonResponse jsonResponse) {
        try {

            System.out.println("annonce"+ jsonResponse.getAnnonce());
            Employer e = utilisateurService.getempByToken(jsonResponse.getToken());
            jsonResponse.getAnnonce().setId_utilisateur(e.getId().intValue());

            return Etat.builder().status("ok").details("update ok").object(annonceRepository.save(jsonResponse.getAnnonce())).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).object(jsonResponse).build();
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat update(@RequestBody Annonce annonce) {
        try {
            return Etat.builder().status("ok").details("update ok").object(annonceRepository.save(annonce)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @Secured("ADMIN")
    @PostMapping("/valider/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public Etat valider(@PathVariable int id) {
        try {
            System.out.println("annonce "+id);
            Annonce a = annonceRepository.findById(id).get();
            return Etat.builder().status("ok").details("update ok").object(annonceService.validation_annonce(a)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @GetMapping("/listnonvalider")
    public Etat listnonvalider() {
        try {
            List<Annonce> lista = annonceRepository.get_list_annonce_attente();
            annonceService.initialisation(lista);
            return Etat.builder().status("ok").details("register ok").object(lista).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }


    @GetMapping("/list")
    public Etat list() {
        try {
            List<Annonce> lista = annonceRepository.get_list_annonce_valider();
            annonceService.initialisation(lista);
            return Etat.builder().status("ok").details("register ok").object(lista).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/vendu/{id}")
    @PreAuthorize("hasRole('USER')")
    public Etat vendu(int id) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            return Etat.builder().status("ok").details("register ok").object(annonceService.vendu_annonce(a)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/favoris")
    @PreAuthorize("hasAuthority('USER')")
    public Etat favoris(@RequestBody JsonResponse reponse) {
        try {
            String email = jwtService.extractUsername(reponse.getToken());
//            System.out.println(email);
            Employer e = employerRepository.findEmployerByEmail(email).get();
            Annonce_favoris annonceFavoris = new Annonce_favoris();
            annonceFavoris.setId_annonce(Integer.valueOf(reponse.getObject().toString()));
            annonceFavoris.setId_employer(e.getId().intValue());

            return Etat.builder().status("ok").details("register ok").object(annonceFavorisRepository.save(annonceFavoris)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
        }
    }

    @PostMapping("/file")
    public Etat uploadFile(@RequestBody FilesBody files) {
        try {
            FileHelper file = new FileHelper();
//            for (String fileBase64 : files.getFiles()) {
                // file.upload(fileBase64);
                Photos_annonce an = (Photos_annonce) file.uploadOnline(files.getFiles(),files.getId_annonce());
                photosAnnonceRepository.save(an);
//            }
            return Etat.builder().status("ok").details("File uploaded").object(an).build();
        } catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }

    @GetMapping("/lastid")
    public Etat getlastidannonce() {
        try {
            int last = annonceRepository.getlastid_annonce();

            return Etat.builder().status("ok").details("get last").object(last).build();
        }catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }

    @GetMapping("/get/{id}")
    public Etat getid(@PathVariable int id) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            annonceService.initialisation(a);
            return Etat.builder().status("ok").details("get id").object(a).build();
        }catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }

    @PostMapping("/listfavoris")
    public Etat listfavoris(@RequestBody JsonResponse jsonResponse) {
        try {
            Employer e = utilisateurService.getempByToken(jsonResponse.getToken());
            List<Annonce> annonceList = annonceService.getFavorisByUsers(e.getId().intValue());
            return Etat.builder().status("ok").details("get list annonce favoris").object(annonceList).build();
        }catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }

    @PostMapping("/listbyuser")
    public Etat listByUser(@RequestBody JsonResponse jsonResponse) {
        try {
            Employer e = utilisateurService.getempByToken(jsonResponse.getToken());
            List<Annonce> annonceList = annonceService.get_annonce_by_utilisateur(e.getId().intValue());
            annonceService.initialisation(annonceList);
            return Etat.builder().status("ok").details("get list annonce by users").object(annonceList).build();
        }catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }
}
