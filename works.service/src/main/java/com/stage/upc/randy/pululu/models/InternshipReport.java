package com.stage.upc.randy.pululu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InternshipReport extends Work {
    private String entreprise;
    private String encadreur;

}
