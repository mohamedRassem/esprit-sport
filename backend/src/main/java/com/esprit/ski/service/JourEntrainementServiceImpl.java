package com.esprit.ski.service;

import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.JourEntrainement;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.repositroy.JourEntrainementRepository;
import com.esprit.ski.repositroy.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JourEntrainementServiceImpl implements IJourEntrainementService {

    @Autowired
    JourEntrainementRepository jourEntrainementRepository;



    @Override
    public JourEntrainement addJourEntrainement(JourEntrainement O) {
        JourEntrainement jourEntrainement = jourEntrainementRepository.save(O);
        return jourEntrainement;
    }



    @Transactional
    public JourEntrainement updateJourEntrainement(Long id, JourEntrainement updatedJourEntrainement) {
        if (jourEntrainementRepository.existsById(id)) {
            updatedJourEntrainement.setId(id);
            return jourEntrainementRepository.save(updatedJourEntrainement);
        }
        return null; // Gérez le cas où l'exercice n'existe pas
    }

    public void deleteJourEntrainement(Long id) {
        jourEntrainementRepository.deleteById(id);
    }


    @Override
    public JourEntrainement retrieveJourEntrainement(Long Id) {
        return null;
    }


    }


