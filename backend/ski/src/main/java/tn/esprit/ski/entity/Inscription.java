package tn.esprit.ski.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Inscription")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Long numInscription;
    private int numSemaine;
    @ManyToOne
    private Cours cours;
    @ManyToOne
    private Skieur skieurs;



}
