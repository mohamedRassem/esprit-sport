package com.esprit.ski.service;

import com.esprit.ski.entity.Entrainement;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.JourEntrainement;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.repositroy.EntrainementRepository;
import com.esprit.ski.repositroy.JourEntrainementRepository;
import com.esprit.ski.repositroy.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EntrainementServiceImpl implements IEntrainementService {

    @Autowired
    EntrainementRepository entrainementRepository;

    @Autowired
    JourEntrainementRepository jourEntrainementRepository;



    @Override
    public Entrainement addEntrainement(Entrainement O) {
        Entrainement entrainement = entrainementRepository.save(O);
        return entrainement;
    }


    @Transactional
    public Entrainement updateEntrainement(Long id, Entrainement updatedEntrainement) {
        if (entrainementRepository.existsById(id)) {
            updatedEntrainement.setId(id);
            return entrainementRepository.save(updatedEntrainement);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }

    public void deleteEntrainement(Long id) {
        entrainementRepository.deleteById(id);
    }



















    @Override
    public Entrainement retrieveEntrainement(Long Id) {
        return null;
    }



    public void affecterJourEntrainementParEntrainement(Long entrainementId, Long jourEntrainementId) {
        Entrainement entrainement = entrainementRepository.findById(entrainementId).orElse(null);
        JourEntrainement jourEntrainement = jourEntrainementRepository.findById(jourEntrainementId).orElse(null);

        if (entrainement != null && jourEntrainement != null) {
            entrainement.setJour(jourEntrainement);
            entrainementRepository.save(entrainement);
        }
    }


    public Long getJourEntrainementIdForEntrainement(Long entrainementId) {
        Entrainement entrainement = entrainementRepository.findById(entrainementId).orElse(null);

        if (entrainement != null && entrainement.getJour() != null) {
            return entrainement.getJour().getId();
        } else {
            return null;
        }
    }
}

