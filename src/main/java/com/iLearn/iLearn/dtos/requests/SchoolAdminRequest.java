package com.iLearn.iLearn.dtos.requests;

import com.iLearn.iLearn.models.ClassLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolAdminRequest {

    private String firstname;
    private String lastname;
    private ClassLevel setClassLevelArm;
}
