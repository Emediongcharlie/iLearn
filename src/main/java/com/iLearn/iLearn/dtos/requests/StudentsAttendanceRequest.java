package com.iLearn.iLearn.dtos.requests;

import com.iLearn.iLearn.models.ClassLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class StudentsAttendanceRequest {

    private int id;
    private LocalDateTime timeAndDate;
    private String firstname;
    private String lastname;
    private ClassLevel arm;
}
