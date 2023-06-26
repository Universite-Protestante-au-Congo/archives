package com.stage.upc.randy.pululu.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    private String libelle;
    private String professeur;
    private String assistant;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Interrogation> interrogations;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PraticalWork> praticalWorks;
}
