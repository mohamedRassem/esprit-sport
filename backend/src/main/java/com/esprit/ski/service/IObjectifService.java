package com.esprit.ski.service;



import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IObjectifService {


    public Objectif addObjectif(Objectif O);




  /*  public List<Utilisateur> getUtilisateursParObjectif(Long objectifId);*/





    public Long getUtilisateurIdForObjectif(Long objectifId);

}
