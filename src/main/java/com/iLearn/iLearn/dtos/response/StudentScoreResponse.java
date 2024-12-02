package com.iLearn.iLearn.dtos.response;

import com.iLearn.iLearn.models.Grade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentScoreResponse {

    private String firstname;
    private String lastname;
    private int score;
    private Grade grade;
}
