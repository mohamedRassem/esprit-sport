package com.esprit.ski.controller;


import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.PlanEntrainement;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.service.IObjectifService;
import com.esprit.ski.service.IPlanEntrainementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Objectif")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class PlanEntrainementRestController {


    @Autowired
    IPlanEntrainementService planEntrainementService;

    @PostMapping("/add-PlanEntrainement")
    public PlanEntrainement addPlanEntrainement(@RequestBody PlanEntrainement O) {
        PlanEntrainement planEntrainement = planEntrainementService.addPlanEntrainement(O);
        return planEntrainement;
    }
























    @GetMapping("/retrieve-PlanEntrainement/{PlanEntrainement-id}")
    public PlanEntrainement retrievePlanEntrainement(@PathVariable("PlanEntrainement-id") Long Id) {
        PlanEntrainement planEntrainement = planEntrainementService.retrievePlanEntrainement(Id);
        return planEntrainement;
    }




    @PostMapping("/{planEntrainementId}/affecter-objectif/{objectifId}")
    public ResponseEntity<Void> affecterObjectifParPlanEntrainement(@PathVariable Long planEntrainementId, @PathVariable Long objectifId) {
        planEntrainementService.affecterObjectifParPlanEntrainement(planEntrainementId, objectifId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{planEntrainementId}/objectif-id")
    public ResponseEntity<Long> getObjectifIdForPlanEntrainement(@PathVariable Long planEntrainementId) {
        Long objectifId = planEntrainementService.getObjectifIdForPlanEntrainement(planEntrainementId);

        if (objectifId != null) {
            return ResponseEntity.ok(objectifId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





















}

