package com.esprit.ski.repositroy;

import com.esprit.ski.entity.JourEntrainement;
import com.esprit.ski.entity.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourEntrainementRepository extends JpaRepository<JourEntrainement, Long> {


}

