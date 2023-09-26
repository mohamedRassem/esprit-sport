package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Entrainement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int sets;
    private int repetitions;


    @ManyToOne
    @JoinColumn(name = "jour_id")
    private JourEntrainement jour;

    @ManyToOne
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;



}

