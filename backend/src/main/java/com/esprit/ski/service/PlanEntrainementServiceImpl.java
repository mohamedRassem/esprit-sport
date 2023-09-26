package com.esprit.ski.service;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.PlanEntrainement;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.repositroy.ObjectifRepository;
import com.esprit.ski.repositroy.PlanEntrainementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlanEntrainementServiceImpl implements  IPlanEntrainementService {

    @Autowired
    PlanEntrainementRepository planEntrainementRepository;

    @Autowired
    ObjectifRepository objectifRepository;





    @Override
    public PlanEntrainement addPlanEntrainement(PlanEntrainement O) {
        PlanEntrainement planEntrainement =planEntrainementRepository.save(O);
        return planEntrainement;
    }
















    @Override
    public PlanEntrainement retrievePlanEntrainement(Long Id) {
        return null;
    }



    public void affecterObjectifParPlanEntrainement(Long planEntrainementId, Long objectifId) {
        PlanEntrainement planEntrainement = planEntrainementRepository.findById(planEntrainementId).orElse(null);
        Objectif objectif = objectifRepository.findById(objectifId).orElse(null);

        if (planEntrainement != null && objectif != null) {
            planEntrainement.setObjectif(objectif);
            planEntrainementRepository.save(planEntrainement);
        }
    }



    public Long getObjectifIdForPlanEntrainement(Long planEntrainementId) {
        PlanEntrainement planEntrainement = planEntrainementRepository.findById(planEntrainementId).orElse(null);

        if (planEntrainement != null && planEntrainement.getObjectif() != null) {
            return planEntrainement.getObjectif().getId();
        } else {
            return null;
        }
    }




}

