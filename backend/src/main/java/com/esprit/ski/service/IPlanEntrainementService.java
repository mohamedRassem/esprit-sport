package com.esprit.ski.service;



import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.PlanEntrainement;
import com.esprit.ski.entity.Utilisateur;

public interface IPlanEntrainementService {

    public PlanEntrainement retrievePlanEntrainement(Long Id);
    public PlanEntrainement addPlanEntrainement(PlanEntrainement O);







    public void affecterObjectifParPlanEntrainement(Long planEntrainementId, Long objectifId);

    public Long getObjectifIdForPlanEntrainement(Long planEntrainementId);
}
