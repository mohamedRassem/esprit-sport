package com.esprit.ski.controller;


import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.service.IExerciceService;
import com.esprit.ski.service.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercices")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class ExerciceRestController {


    @Autowired
    IExerciceService exerciceService;

    @PostMapping("/ajouter")
    public ResponseEntity<Exercice> ajouterExercice(@RequestBody Exercice exercice) {
        Exercice nouveauExercice = exerciceService.ajouterExercice(exercice);
        return new ResponseEntity<>(nouveauExercice, HttpStatus.CREATED);
    }




    @PutMapping("/modifier/{nom}")
    public ResponseEntity<Exercice> modifierExerciceParNom(@PathVariable String nom, @RequestBody Exercice exercice) {
        Exercice exerciceModifie = exerciceService.modifierExerciceParNom(nom, exercice);
        if (exerciceModifie != null) {
            return new ResponseEntity<>(exerciceModifie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







    @DeleteMapping("/supprimer/{nom}")
    public ResponseEntity<Void> supprimerExerciceParNom(@PathVariable String nom) {
        exerciceService.supprimerExerciceParNom(nom);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





















    @GetMapping("/retrieve-Exercice/{Exercice-id}")
    public Exercice retrieveExercice(@PathVariable("Exercice-id") Long Id) {
        Exercice exercice = exerciceService.retrieveExercice(Id);
        return exercice;
    }

}

