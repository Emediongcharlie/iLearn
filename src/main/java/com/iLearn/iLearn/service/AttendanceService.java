package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StaffAttendanceRequest;
import com.iLearn.iLearn.dtos.requests.StudentsAttendanceRequest;
import com.iLearn.iLearn.dtos.response.StaffAttendanceResponse;
import com.iLearn.iLearn.models.Attendance;

import java.util.List;

public interface AttendanceService {

//    StudentAttendanceResponse studentAttendance(StudentAttendanceRequest request);
//
    StaffAttendanceResponse staffAttendance(StaffAttendanceRequest request);

    List<Attendance> numberOfTimesPresent(StaffAttendanceRequest request);

    int countDaysPresent(StaffAttendanceRequest request);
}
