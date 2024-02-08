package com.example.ventevoiture.controller;

import com.example.ventevoiture.model.*;
import com.example.ventevoiture.repository.AnnonceRepository;
import com.example.ventevoiture.repository.Annonce_favorisRepository;
import com.example.ventevoiture.repository.Photos_annonceRepository;
import com.example.ventevoiture.repository.VoitureRepository;
import com.example.ventevoiture.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        annonceRepository.deleteById(id);
    }

    @PutMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Etat insert(@RequestBody Annonce annonce) {
        try {
            return Etat.builder().status("ok").details("update ok").object(annonceRepository.save(annonce)).build();
        } catch (Exception e) {
            return Etat.builder().status("erreur").details(e.getMessage()).build();
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

    @PostMapping("/valider/{id}")
    @PreAuthorize("hasRole('ADMIN')")
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
    public Etat favoris(@RequestBody Annonce_favoris af) {
        try {
            return Etat.builder().status("ok").details("register ok").object(annonceFavorisRepository.save(af)).build();
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
    public Etat getid(int id) {
        try {
            Annonce a = annonceRepository.findById(id).get();

            return Etat.builder().status("ok").details("get id").object(a).build();
        }catch (Exception e) {
            return Etat.builder().status("error").details(e.getMessage()).build();
        }
    }

}
