package tn.esprit.ski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ski.Service.IPisteService;
import tn.esprit.ski.entity.Piste;

import java.util.List;

@RestController
@RequestMapping("/piste")
public class PisteRestController {
    @Autowired
    IPisteService pisteService;

    // http://localhost:8089/ski/piste/retrieve-all-pistes
    @GetMapping("/retrieve-all-pistes")
    public List<Piste> getPistes() {
        List<Piste> listPistes = pisteService.retrieveAllPistes();
        return listPistes;
    }

    // http://localhost:8089/SpringMVC/piste/retrieve-piste/8
    @GetMapping("/retrieve-piste/{piste-id}")
    public Piste retrievePiste(@PathVariable("piste-id") Long proejtId) {
        Piste piste = pisteService.retrievePiste(proejtId);
        return piste;
    }

    @PostMapping("/add-piste")
    public Piste addPiste(@RequestBody Piste p) {
        Piste piste = pisteService.addPiste(p);
        return piste;
    }

    // http://localhost:8089/SpringMVC/piste/remove-piste/{piste-id}
    @DeleteMapping("/remove-piste/{piste-id}")
    public void removePiste(@PathVariable("piste-id") Long proejtId) {
        pisteService.removePiste(proejtId);
    }

    // http://localhost:8089/SpringMVC/piste/modify-piste
    @PutMapping("/modify-piste")
    public Piste modifyPiste(@RequestBody Piste p) {
        Piste piste = pisteService.modifyPiste(p);
        return piste;
    }
}
