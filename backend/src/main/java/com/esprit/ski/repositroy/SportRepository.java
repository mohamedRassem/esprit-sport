package com.esprit.ski.repositroy;

import com.esprit.ski.entity.Objectif;
import com.esprit.ski.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {


}

