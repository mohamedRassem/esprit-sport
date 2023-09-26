package com.esprit.ski.repositroy;

import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

    void deleteByNom(String nom);

    Exercice findByNom(String nom);

}

