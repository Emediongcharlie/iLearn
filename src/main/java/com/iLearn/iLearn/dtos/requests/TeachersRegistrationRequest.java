package com.iLearn.iLearn.dtos.requests;

import com.iLearn.iLearn.models.SubjectsOffered;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeachersRegistrationRequest {

    private String teachersName;
    private String username;
    private String teachersBio;
    private SubjectsOffered subjectHandled;

}
