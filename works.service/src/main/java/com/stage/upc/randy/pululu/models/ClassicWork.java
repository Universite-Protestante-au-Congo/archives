package com.stage.upc.randy.pululu.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassicWork extends Work {
    private int note;
}
