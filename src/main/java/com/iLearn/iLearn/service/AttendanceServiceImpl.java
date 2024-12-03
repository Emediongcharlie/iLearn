package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StaffAttendanceRequest;
import com.iLearn.iLearn.dtos.response.StaffAttendanceResponse;
import com.iLearn.iLearn.models.Attendance;
import com.iLearn.iLearn.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public StaffAttendanceResponse staffAttendance(StaffAttendanceRequest request) {
        Attendance attendance  = new Attendance();
        attendance.setFirstname(request.getFirstname());
        attendance.setLastname(request.getLastname());
//        attendance.setTimeAndDate(request.getTime());
        String dateTime = ("01-11-2023 01:03:04");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        attendance.setTimeAndDate(LocalDateTime.parse(dateTime));
//        attendance.setTimeAndDate(request.getTime());
        attendanceRepository.save(attendance);
        StaffAttendanceResponse response = new StaffAttendanceResponse();
        response.setFirstname(attendance.getFirstname());
        response.setLastname(attendance.getLastname());
        response.setMessage("Attendance Logged successfully!");
        return response;
    }

    @Override
    public List<Attendance> numberOfTimesPresent(StaffAttendanceRequest request) {
        List<Attendance>staffAttendanceList = new ArrayList<>();

        for(Attendance att: attendanceRepository.findAll()){
            if(att.getFirstname().equals(request.getFirstname()) && att.getLastname().equals(request.getLastname())){
                staffAttendanceList.add(att);
            }
        }
        return staffAttendanceList;
    }

    @Override
    public int countDaysPresent(StaffAttendanceRequest request) {
        int count = 0;
        for(Attendance attendance : attendanceRepository.findAll()){
            if(attendance.getFirstname().equals(request.getFirstname()) && attendance.getLastname().equals(request.getLastname())){
                count++;
            }
        }
        return count;
    };
    }

