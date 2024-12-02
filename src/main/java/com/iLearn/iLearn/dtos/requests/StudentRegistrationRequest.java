package com.iLearn.iLearn.dtos.requests;

import com.iLearn.iLearn.models.ClassLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRegistrationRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ClassLevel arm;
    private int age;

}
