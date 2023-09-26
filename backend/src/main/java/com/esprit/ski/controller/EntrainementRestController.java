package com.esprit.ski.controller;


import com.esprit.ski.entity.Entrainement;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.service.IEntrainementService;
import com.esprit.ski.service.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Entrainement")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class EntrainementRestController {


    @Autowired
    IEntrainementService entrainementService;

    @PostMapping("/add-Entrainement")
    public Entrainement addEntrainement(@RequestBody Entrainement O) {
        Entrainement entrainement = entrainementService.addEntrainement(O);
        return entrainement;
    }






    @GetMapping("/retrieve-Entrainement/{Entrainement-id}")
    public Entrainement retrieveEntrainement(@PathVariable("Entrainement-id") Long Id) {
        Entrainement entrainement = entrainementService.retrieveEntrainement(Id);
        return entrainement;
    }











    @PutMapping("/{id}")
    public ResponseEntity<Entrainement> updateEntrainement(@PathVariable Long id, @RequestBody Entrainement updatedEntrainement) {
        Entrainement updated = entrainementService.updateEntrainement(id, updatedEntrainement);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrainement(@PathVariable Long id) {
        entrainementService.deleteEntrainement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




























    @PostMapping("/{entrainementId}/affecter-jour/{jourEntrainementId}")
    public ResponseEntity<Void> affecterJourEntrainementParEntrainement(@PathVariable Long entrainementId, @PathVariable Long jourEntrainementId) {
        entrainementService.affecterJourEntrainementParEntrainement(entrainementId, jourEntrainementId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{entrainementId}/jour-id")
    public ResponseEntity<Long> getJourEntrainementIdForEntrainement(@PathVariable Long entrainementId) {
        Long jourEntrainementId = entrainementService.getJourEntrainementIdForEntrainement(entrainementId);

        if (jourEntrainementId != null) {
            return ResponseEntity.ok(jourEntrainementId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

