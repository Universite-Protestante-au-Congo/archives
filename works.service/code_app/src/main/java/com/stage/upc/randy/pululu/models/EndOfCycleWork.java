package com.stage.upc.randy.pululu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.nio.file.Path;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EndOfCycleWork extends Work{
    private String sujet;
    private String directeur;
    private String mention;
    private String auteur;
}
