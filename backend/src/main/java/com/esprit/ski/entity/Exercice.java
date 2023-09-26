package com.esprit.ski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String description;






}

