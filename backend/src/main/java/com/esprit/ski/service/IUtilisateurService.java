package com.esprit.ski.service;



import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;

import java.util.List;

public interface IUtilisateurService {


    public Utilisateur getUtilisateurById(Long id);
    public Utilisateur addUtilisateur(Utilisateur U);


    public Utilisateur mettreAJourUtilisateurParNom(String nomUtilisateur, Utilisateur utilisateur);
    public void supprimerUtilisateurParNom(String nomUtilisateur);

    Objectif affecterUtilisateurParObjectif(Long objectifId, Long utilisateurId);

    public void ajouterSportAUtilisateur(Long utilisateurId, Long sportId);



}
