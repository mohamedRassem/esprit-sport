package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    private
    Date dateInscription;

    private int age;
    private String sexe;
    private double poids;
    private double taille;
    private String niveauForme;


    @OneToMany(targetEntity = Objectif.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="Utilisateur_id")
    private List<Objectif> objectifs;


    @ManyToMany
    @JoinTable(name = "utilisateur_sport",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id"))
    private List<Sport> sports = new ArrayList<>();
}

