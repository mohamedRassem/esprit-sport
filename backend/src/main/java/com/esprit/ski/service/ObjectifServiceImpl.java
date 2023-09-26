package com.esprit.ski.service;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.repositroy.ObjectifRepository;
import com.esprit.ski.repositroy.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ObjectifServiceImpl implements IObjectifService {


    @Autowired
    private ObjectifRepository objectifRepository;



    @Override
    public Objectif addObjectif(Objectif O) {
        return null;
    }








  /*  public List<Utilisateur> getUtilisateursParObjectif(Long objectifId) {
        Objectif objectif = objectifRepository.findById(objectifId).orElse(null);

        if (objectif != null) {
            return objectif.getUtilisateurs();
        } else {
            return Collections.emptyList();
        }


    }*/

    public Long getUtilisateurIdForObjectif(Long objectifId) {
        Objectif objectif = objectifRepository.findById(objectifId).orElse(null);

        if (objectif != null && objectif.getUtilisateur() != null) {
            return objectif.getUtilisateur().getId();
        } else {
            return null;
        }
    }







}

