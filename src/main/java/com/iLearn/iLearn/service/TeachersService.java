package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StudentScoreRequest;
import com.iLearn.iLearn.dtos.requests.StudentsAttendanceRequest;
import com.iLearn.iLearn.dtos.requests.TeachersRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentAttendanceResponse;
import com.iLearn.iLearn.dtos.response.StudentScoreResponse;
import com.iLearn.iLearn.dtos.response.TeachersRegistrationResponse;
import com.iLearn.iLearn.models.Attendance;

import java.util.List;

public interface TeachersService {

    TeachersRegistrationResponse register(TeachersRegistrationRequest request);

    StudentAttendanceResponse attendanceRecord(StudentsAttendanceRequest request);

    List<Attendance> numberOfTimesPresent(StudentsAttendanceRequest request);


    int countDaysPresent(StudentsAttendanceRequest request);

    StudentScoreResponse studentScoresRecord(StudentScoreRequest request);

}
