package com.esprit.ski.repositroy;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    Utilisateur findByNom(String nomUtilisateur);
}

