package com.stage.upc.randy.pululu.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private int annee;
    private String faculte;
    private String promotion;
    private String departement;
    private String auteur;

    @OneToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "file")
    private WorkFile workFile;
}
