package com.iLearn.iLearn.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Score score;
    private Performance studentPerformance;
}
