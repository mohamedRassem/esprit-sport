package com.esprit.ski.service;

import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.repositroy.ExerciceRepository;
import com.esprit.ski.repositroy.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExerciceServiceImpl implements IExerciceService {

    @Autowired
    ExerciceRepository exerciceRepository;



    @Override
    public Exercice ajouterExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }


    @Override
    public Exercice modifierExerciceParNom(String nom, Exercice exercice) {
        Exercice exerciceExist = exerciceRepository.findByNom(nom);
        if (exerciceExist != null) {
            exerciceExist.setNom(exercice.getNom());
            exerciceExist.setDescription(exercice.getDescription());
            return exerciceRepository.save(exerciceExist);
        }
        return null;
    }

    @Override
    public void supprimerExerciceParNom(String nom) {
        exerciceRepository.deleteByNom(nom);
    }































    @Override
    public Exercice retrieveExercice(Long Id) {
        return null;
    }


}

