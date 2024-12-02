package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StudentRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentRegistrationResponse;
import com.iLearn.iLearn.exceptions.UsernameAlreadyExistException;
import com.iLearn.iLearn.models.ClassLevel;
import com.iLearn.iLearn.models.Student;
import com.iLearn.iLearn.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    @Override
    public StudentRegistrationResponse register(StudentRegistrationRequest request) {
        Student student = new Student();
        entryValidation(request.getUsername());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setUsername(request.getUsername());
        student.setArm(ClassLevel.valueOf(String.valueOf(request.getArm())));
        student.setAge(request.getAge());
        studentRepository.save(student);
        StudentRegistrationResponse response = new StudentRegistrationResponse();
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setAge(student.getAge());
        response.setMessage("Registered Successfully");
        return response;
    }

    private void entryValidation(String username){
        Optional<Student> validation = studentRepository.findByUsername(username);
        if(validation.isPresent()){
            throw new UsernameAlreadyExistException("found already");
        }

    }
}
