package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlanEntrainement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String descreption;

    @ManyToOne
    @JoinColumn(name = "objectif_id")
    private Objectif objectif;





}

