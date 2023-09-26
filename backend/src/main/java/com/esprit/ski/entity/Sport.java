package com.esprit.ski.entity;

import lombok.*;

import javax.net.ssl.SSLSession;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String descreption;


    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieSport categorie;


    @ManyToMany(mappedBy = "sports")
    private List<Utilisateur> utilisateurs = new ArrayList<>();




}

