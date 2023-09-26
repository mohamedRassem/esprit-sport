package com.esprit.ski.service;



import com.esprit.ski.entity.CategorieSport;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Utilisateur;

public interface ICategorieSportService {

    public CategorieSport retrieveCategorieSport(Long Id);
    public CategorieSport addCategorieSport(CategorieSport C);



}
