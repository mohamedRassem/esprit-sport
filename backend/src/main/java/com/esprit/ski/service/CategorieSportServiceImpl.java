package com.esprit.ski.service;

import com.esprit.ski.entity.CategorieSport;
import com.esprit.ski.entity.Exercice;
import com.esprit.ski.entity.Objectif;
import com.esprit.ski.repositroy.CategorieSportRepository;
import com.esprit.ski.repositroy.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategorieSportServiceImpl implements ICategorieSportService {

    @Autowired
    CategorieSportRepository categorieSportRepository;



    @Override
    public CategorieSport addCategorieSport(CategorieSport C) {
        CategorieSport categorieSport = categorieSportRepository.save(C);
        return categorieSport;
    }
























    @Override
    public CategorieSport retrieveCategorieSport(Long Id) {
        return null;
    }


}

