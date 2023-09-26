package com.esprit.ski.service;



import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.JourEntrainement;
import com.esprit.ski.entity.Objectif;

public interface IJourEntrainementService {

    public JourEntrainement retrieveJourEntrainement(Long Id);
    public JourEntrainement addJourEntrainement(JourEntrainement O);

    public JourEntrainement updateJourEntrainement(Long id, JourEntrainement updatedJourEntrainement);

    public void deleteJourEntrainement(Long id);
}
