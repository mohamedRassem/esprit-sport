package com.esprit.ski.service;



import com.esprit.ski.entity.Entrainement;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;

public interface IEntrainementService {

    public Entrainement retrieveEntrainement(Long Id);
    public Entrainement addEntrainement(Entrainement O);

    public Entrainement updateEntrainement(Long id, Entrainement updatedEntrainement);

    public void deleteEntrainement(Long id);

    public void affecterJourEntrainementParEntrainement(Long entrainementId, Long jourEntrainementId);

    public Long getJourEntrainementIdForEntrainement(Long entrainementId);
}
