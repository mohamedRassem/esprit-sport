package com.esprit.ski.controller;


import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.service.IObjectifService;
import com.esprit.ski.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Sport")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class SportRestController {


    @Autowired
    ISportService sportService;

    @PostMapping("/add-Sport")
    public Sport addSport(@RequestBody Sport O) {
        Sport sport =sportService.addSport(O);
        return sport;
    }



    @PutMapping("/{id}")
    public ResponseEntity<Sport> updateSport(@PathVariable Long id, @RequestBody Sport updatedSport) {
        Sport updated = sportService.updateSport(id, updatedSport);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSport(@PathVariable Long id) {
        sportService.deleteSport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





















    @GetMapping("/retrieve-Sport/{Sport-id}")
    public Sport retrieveSport(@PathVariable("Sport-id") Long Id) {
        Sport sport = sportService.retrieveSport(Id);
        return sport;
    }





    @PostMapping("/{sportId}/affecter-categorie/{categorieSportId}")
    public ResponseEntity<Void> affecterCategorieSportParSport(@PathVariable Long sportId, @PathVariable Long categorieSportId) {
        sportService.affecterCategorieSportParSport(sportId, categorieSportId);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{sportId}/categorie-id")
    public ResponseEntity<Long> getCategorieSportIdForSport(@PathVariable Long sportId) {
        Long categorieSportId = sportService.getCategorieSportIdForSport(sportId);

        if (categorieSportId != null) {
            return ResponseEntity.ok(categorieSportId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{sportId}/ajouter-utilisateur/{utilisateurId}")
    public ResponseEntity<Void> ajouterUtilisateurASport(@PathVariable Long sportId, @PathVariable Long utilisateurId) {
        sportService.ajouterUtilisateurASport(sportId, utilisateurId);
        return ResponseEntity.ok().build();
    }
























}

