package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StudentRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentRegistrationResponse;

public interface StudentService {

    StudentRegistrationResponse register(StudentRegistrationRequest request);
}
