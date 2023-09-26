package tn.esprit.ski.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Skieur")
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSkieur")
    private Integer idSkieur; // Clé primaire
    private Long numSkieur;
    private String nomS;
    private  String prenomS;
    @Temporal (TemporalType.DATE)
    private Date dateNaissance;
    private String ville ;
    @OneToOne
    private Abonnement abonnement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="skieurs")
    private Set<Inscription> inscriptionsSki;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Piste> pistes;

}
