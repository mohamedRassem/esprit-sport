package com.esprit.ski.repositroy;

import com.esprit.ski.entity.Entrainement;
import com.esprit.ski.entity.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrainementRepository extends JpaRepository<Entrainement, Long> {


}

