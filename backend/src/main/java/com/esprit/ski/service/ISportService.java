package com.esprit.ski.service;



import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;

public interface ISportService {

    public Sport retrieveSport(Long Id);
    public Sport addSport(Sport O);

    public Sport updateSport(Long id, Sport updatedSport);

    public void deleteSport(Long id);

    public void affecterCategorieSportParSport(Long sportId, Long categorieSportId);

    public Long getCategorieSportIdForSport(Long sportId);


    public void ajouterUtilisateurASport(Long sportId, Long utilisateurId);














}
