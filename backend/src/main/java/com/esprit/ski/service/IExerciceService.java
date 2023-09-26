package com.esprit.ski.service;



import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;

public interface IExerciceService {

    public Exercice retrieveExercice(Long Id);
    Exercice ajouterExercice(Exercice exercice);



    Exercice modifierExerciceParNom(String nom, Exercice exercice);
    void supprimerExerciceParNom(String nom);


}
