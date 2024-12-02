package com.iLearn.iLearn.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegistrationResponse {

    private String studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String message;

}
