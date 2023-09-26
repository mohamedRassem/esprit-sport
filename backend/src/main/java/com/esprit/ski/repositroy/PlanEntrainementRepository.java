package com.esprit.ski.repositroy;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.PlanEntrainement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEntrainementRepository extends JpaRepository<PlanEntrainement, Long> {


}

