package com.example.ventevoiture.repository;

import com.example.ventevoiture.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
    // get all annonce izay efa valider
    @Query("from annonce where id_status >= 5")
    public List<Annonce> get_list_annonce_valider();

    // maka annonce rehetra par utilisateur (historique)
    @Query("from annonce  where id_utilisateur = ?1")
    public List<Annonce> get_list_annonce_byIdUser(int id_utilisateur);

    // maka isanah vente rehetra
    @Query("select count(id_annonce) from annonce where id_status >= 10")
    public int get_count_vente();

    @Query("from annonce  where  id_status < 5")
    public List<Annonce> get_list_annonce_attente();

    @Query("select max(id_annonce) from annonce")
    public int getlastid_annonce();

}
