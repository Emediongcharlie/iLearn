package com.iLearn.iLearn.dtos.requests;

import com.iLearn.iLearn.models.Grade;
import com.iLearn.iLearn.models.SubjectsOffered;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentScoreRequest {

    private String firstname;
    private String lastname;
    private Grade grade;
    private int studentScore;
    private int NumberOfSubjects;
    private SubjectsOffered subject;
}
