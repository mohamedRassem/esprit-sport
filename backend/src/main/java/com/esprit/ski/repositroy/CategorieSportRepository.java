package com.esprit.ski.repositroy;

import com.esprit.ski.entity.CategorieSport;
import com.esprit.ski.entity.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieSportRepository extends JpaRepository<CategorieSport, Long> {


}

