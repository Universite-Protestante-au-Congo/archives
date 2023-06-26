package com.stage.upc.randy.pululu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PraticalWork extends ClassicWork{
    private String sujet;
    @ManyToOne
    private Course Cours;
}
