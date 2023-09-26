package com.esprit.ski.controller;


import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.service.IObjectifService;
import com.esprit.ski.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class UtilisateurRestController {


    @Autowired
    IUtilisateurService utilisateurService;

    @Autowired
    IObjectifService objectifService;




    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

















    @PostMapping("/add-Utilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur U) {
        Utilisateur utilisateur = utilisateurService.addUtilisateur(U);
        return utilisateur;
    }











    @DeleteMapping("/supprimer/{nomUtilisateur}")
    public ResponseEntity<String> supprimerUtilisateurParNom(@PathVariable String nomUtilisateur) {
        try {
            utilisateurService.supprimerUtilisateurParNom(nomUtilisateur);
            return new ResponseEntity<>("Utilisateur supprimé avec succès", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression de l'utilisateur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }











    @PutMapping("/mettre-a-jour/{nomUtilisateur}")
    public ResponseEntity<Utilisateur> mettreAJourUtilisateurParNom(
            @PathVariable String nomUtilisateur,
            @RequestBody Utilisateur utilisateur) {

        Utilisateur utilisateurMisAJour = utilisateurService.mettreAJourUtilisateurParNom(nomUtilisateur, utilisateur);
        return new ResponseEntity<>(utilisateurMisAJour, HttpStatus.OK);
    }







    @PostMapping("/{utilisateurId}/ajouter-sport/{sportId}")
    public ResponseEntity<Void> ajouterSportAUtilisateur(@PathVariable Long utilisateurId, @PathVariable Long sportId) {
        utilisateurService.ajouterSportAUtilisateur(utilisateurId, sportId);
        return ResponseEntity.ok().build();
    }
}














