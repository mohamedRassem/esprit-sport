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
public class JourEntrainement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;



    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanEntrainement plan;



}

