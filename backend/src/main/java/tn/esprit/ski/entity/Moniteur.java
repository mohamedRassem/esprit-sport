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
@Table( name = "Moniteur")
public class Moniteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMoniteur")
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    @Temporal (TemporalType.DATE)
    private Date dateRecru;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cours> coursM;
}
