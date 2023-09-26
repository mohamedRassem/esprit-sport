package com.esprit.ski.controller;


import com.esprit.ski.entity.CategorieSport;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.service.ICategorieSportService;
import com.esprit.ski.service.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Objectif")
@CrossOrigin(origins = "http://localhost:3000") // Remplacez ceci par l'URL de votre application React
public class CategorieSportRestController {


    @Autowired
    ICategorieSportService categorieSportService;

    @PostMapping("/add-CategorieSport")
    public CategorieSport addCategorieSport(@RequestBody CategorieSport C) {
        CategorieSport categorieSport = categorieSportService.addCategorieSport(C);
        return categorieSport;
    }



    @GetMapping("/retrieve-CategorieSport/{CategorieSport-id}")
    public CategorieSport retrieveCategorieSport(@PathVariable("CategorieSport-id") Long Id) {
        CategorieSport categorieSport = categorieSportService.retrieveCategorieSport(Id);
        return categorieSport;
    }

}

