package com.esprit.ski.controller;


import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.service.IObjectifService;
import com.esprit.ski.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Objectif")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class ObjectifRestController {


    @Autowired
    IObjectifService objectifService;
    @Autowired
    private IUtilisateurService utilisateurService;


    @PostMapping("/add-Objectif")
    public Objectif addObjectif(@RequestBody Objectif O) {
        Objectif objectif = objectifService.addObjectif(O);
        return objectif;
    }





    @PutMapping("/{objectifId}/utilisateur/{utilisateurId}")
    public ResponseEntity<String> affecterUtilisateurParObjectif(
            @PathVariable Long objectifId,
            @PathVariable Long utilisateurId) {
        Objectif objectif = utilisateurService.affecterUtilisateurParObjectif(objectifId, utilisateurId);

        if (objectif != null) {
            return ResponseEntity.ok("Objectif lié à l'utilisateur avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Impossible de lier l'objectif à l'utilisateur.");
        } }



 /*   @GetMapping("/{objectifId}/utilisateurs")
    public ResponseEntity<List<Utilisateur>> getUtilisateursParObjectif(@PathVariable Long objectifId) {
        List<Utilisateur> utilisateurs = objectifService.getUtilisateursParObjectif(objectifId);

        if (!utilisateurs.isEmpty()) {
            return ResponseEntity.ok(utilisateurs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

*/

    @GetMapping("/{objectifId}/utilisateurId")
    public ResponseEntity<Long> getUtilisateurIdForObjectif(@PathVariable Long objectifId) {
        Long utilisateurId = objectifService.getUtilisateurIdForObjectif(objectifId);

        if (utilisateurId != null) {
            return ResponseEntity.ok(utilisateurId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}


