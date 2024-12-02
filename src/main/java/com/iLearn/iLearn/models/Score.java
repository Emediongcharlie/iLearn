package com.iLearn.iLearn.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    private Grade grade;
    private int numberOfSubjects;
    private SubjectsOffered subject;

}
