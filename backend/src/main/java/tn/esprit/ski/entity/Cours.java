package tn.esprit.ski.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Cours")
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCours")
    private Integer idCours; // Clé primaire
    private Long numCours ;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours ;
    @Enumerated(EnumType.STRING)
    private Support support ;
    private float prix ;
    private int creneau;
    //Associations
    @OneToMany(cascade = CascadeType.ALL, mappedBy="cours")
    private Set<Inscription> inscriptions;


}
