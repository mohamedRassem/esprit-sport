package com.esprit.ski.service;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import com.esprit.ski.entity.Utilisateur;
import com.esprit.ski.repositroy.ObjectifRepository;
import com.esprit.ski.repositroy.SportRepository;
import com.esprit.ski.repositroy.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {


    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ObjectifRepository objectifRepository;

    @Autowired
    SportRepository sportRepository;
    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur.orElse(null);
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur u) {
        Utilisateur utilisateur = utilisateurRepository.save(u);
        return utilisateur;
    }






    public Utilisateur mettreAJourUtilisateurParNom(String nomUtilisateur, Utilisateur utilisateur) {
        // Recherchez l'utilisateur par son nom d'utilisateur
        Utilisateur utilisateurExistant = utilisateurRepository.findByNom(nomUtilisateur);

        if (utilisateurExistant == null) {
            throw new EntityNotFoundException("L'utilisateur avec le nom " + nomUtilisateur + " n'a pas été trouvé.");
        }

        // Mettez à jour les propriétés de l'utilisateur existant avec les nouvelles valeurs
        utilisateurExistant.setNom(utilisateur.getNom());
        utilisateurExistant.setPrenom(utilisateur.getPrenom());
        utilisateurExistant.setEmail(utilisateur.getEmail());
        utilisateurExistant.setMotDePasse(utilisateur.getMotDePasse());
        utilisateurExistant.setAge(utilisateur.getAge());
        utilisateurExistant.setSexe(utilisateur.getSexe());
        utilisateurExistant.setPoids(utilisateur.getPoids());
        utilisateurExistant.setTaille(utilisateur.getTaille());
        utilisateurExistant.setNiveauForme(utilisateur.getNiveauForme());

        // Enregistrez les modifications dans la base de données
        return utilisateurRepository.save(utilisateurExistant);
    }

    public void supprimerUtilisateurParNom(String nomUtilisateur) {
        // Recherchez l'utilisateur par son nom d'utilisateur
        Utilisateur utilisateur = utilisateurRepository.findByNom(nomUtilisateur);

        if (utilisateur != null) {
            // Si l'utilisateur existe, supprimez-le
            utilisateurRepository.delete(utilisateur);
        } else {
            // Gérez le cas où l'utilisateur n'est pas trouvé, par exemple, en lançant une exception
            throw new EntityNotFoundException("L'utilisateur avec le nom " + nomUtilisateur + " n'a pas été trouvé.");
        }
    }







    public Objectif affecterUtilisateurParObjectif (Long objectifId, Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
        Objectif objectif = objectifRepository.findById(objectifId).orElse(null);

        if (utilisateur != null && objectif != null) {
            objectif.setUtilisateur(utilisateur);
            objectifRepository.save(objectif);
        }

        return objectif;
    }

    public void ajouterSportAUtilisateur(Long utilisateurId, Long sportId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
        Sport sport = sportRepository.findById(sportId).orElse(null);

        if (utilisateur != null && sport != null) {
            utilisateur.getSports().add(sport);
            sport.getUtilisateurs().add(utilisateur);
            utilisateurRepository.save(utilisateur);
            sportRepository.save(sport);
        }
    }





}

