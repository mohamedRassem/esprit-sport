package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategorieSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;


    @OneToMany(mappedBy = "categorie")
    private Set<Sport> sports;



}

