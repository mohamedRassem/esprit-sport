package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Objectif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descreption;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany(mappedBy = "objectifs")
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    @OneToMany(mappedBy = "objectif")
    private List<PlanEntrainement> plansEntrainement = new ArrayList<>();

}


