package tn.esprit.ski.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Abonnement")
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Integer idAbonnement; // Clé primaire
    private Long numAbon ;
    @Temporal (TemporalType.DATE)
    private Date dateDebut;
    @Temporal (TemporalType.DATE)
    private Date dateFin;
   private float PrixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement TypeAbon ;
}
