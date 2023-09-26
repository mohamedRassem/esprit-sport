package com.esprit.ski.service;

import com.esprit.ski.entity.CategorieSport;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.repositroy.CategorieSportRepository;
import com.esprit.ski.repositroy.ObjectifRepository;
import com.esprit.ski.repositroy.SportRepository;
import com.esprit.ski.repositroy.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SportServiceImpl implements ISportService {

    @Autowired
    SportRepository sportRepository;


    @Autowired
    CategorieSportRepository categorieSportRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Sport retrieveSport(Long Id) {
        return null;
    }

    @Override
    public Sport addSport(Sport O) {
        Sport sport = sportRepository.save(O);
        return sport;
    }

    @Transactional
    public Sport updateSport(Long id, Sport updatedSport) {
        if (sportRepository.existsById(id)) {
            updatedSport.setId(id);
            return sportRepository.save(updatedSport);
        }
        return null; // Gérez le cas où l'objectif n'existe pas
    }

    public void deleteSport(Long id) {
        sportRepository.deleteById(id);
    }


    public void affecterCategorieSportParSport(Long sportId, Long categorieSportId) {
        Sport sport = sportRepository.findById(sportId).orElse(null);
        CategorieSport categorieSport = categorieSportRepository.findById(categorieSportId).orElse(null);

        if (sport != null && categorieSport != null) {
            sport.setCategorie(categorieSport);
            sportRepository.save(sport);
        }
    }

    public Long getCategorieSportIdForSport(Long sportId) {
        Sport sport = sportRepository.findById(sportId).orElse(null);

        if (sport != null && sport.getCategorie() != null) {
            return sport.getCategorie().getId();
        } else {
            return null;
        }
    }







    public void ajouterUtilisateurASport(Long sportId, Long utilisateurId) {
        Sport sport = sportRepository.findById(sportId).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);

        if (sport != null && utilisateur != null) {
            sport.getUtilisateurs().add(utilisateur);
            utilisateur.getSports().add(sport);
            sportRepository.save(sport);
            utilisateurRepository.save(utilisateur);
        }
    }





















}

