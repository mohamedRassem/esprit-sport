package com.esprit.ski.controller;


import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.JourEntrainement;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.service.IJourEntrainementService;
import com.esprit.ski.service.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JourEntrainement")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class JourEntrainementRestController {


    @Autowired
    IJourEntrainementService jourEntrainementService;

    @PostMapping("/add-JourEntrainement")
    public JourEntrainement addJourEntrainement(@RequestBody JourEntrainement O) {
        JourEntrainement jourEntrainement = jourEntrainementService.addJourEntrainement(O);
        return jourEntrainement;
    }


    @PutMapping("/{id}")
    public ResponseEntity<JourEntrainement> updateJourEntrainement(@PathVariable Long id, @RequestBody JourEntrainement updatedJourEntrainement) {
        JourEntrainement updated = jourEntrainementService.updateJourEntrainement(id, updatedJourEntrainement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJourEntrainement(@PathVariable Long id) {
        jourEntrainementService.deleteJourEntrainement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
























    @GetMapping("/retrieve-JourEntrainement/{JourEntrainement-id}")
    public JourEntrainement retrieveJourEntrainement(@PathVariable("JourEntrainement-id") Long Id) {
        JourEntrainement jourEntrainement = jourEntrainementService.retrieveJourEntrainement(Id);
        return jourEntrainement;
    }

}

