package com.iLearn.iLearn.service;

import com.iLearn.iLearn.dtos.requests.StudentScoreRequest;
import com.iLearn.iLearn.dtos.requests.StudentsAttendanceRequest;
import com.iLearn.iLearn.dtos.requests.TeachersRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentAttendanceResponse;
import com.iLearn.iLearn.dtos.response.StudentScoreResponse;
import com.iLearn.iLearn.dtos.response.TeachersRegistrationResponse;
import com.iLearn.iLearn.exceptions.UsernameAlreadyExistException;
import com.iLearn.iLearn.models.*;
import com.iLearn.iLearn.repositories.AttendanceRepository;
import com.iLearn.iLearn.repositories.ScoreRepository;
import com.iLearn.iLearn.repositories.TeachersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeachersServiceImpl implements TeachersService{

    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public TeachersRegistrationResponse register(TeachersRegistrationRequest request) {
        Teachers teacher = new Teachers();
        entryValidation(request.getUsername());
        teacher.setTeachersName(request.getTeachersName());
        teacher.setUsername(request.getUsername());
        teacher.setSubjectHandled(request.getSubjectHandled());
        teacher.setTeachersBio(request.getTeachersBio());
        teachersRepository.save(teacher);
        TeachersRegistrationResponse response = new TeachersRegistrationResponse();
        response.setTeacherName(teacher.getTeachersName());
        response.setTeachersBio(teacher.getTeachersBio());
        response.setMessage("Successfully registered!");
        return response;
    }

    @Override
    public StudentAttendanceResponse attendanceRecord(StudentsAttendanceRequest request) {
        Attendance attendance  = new Attendance();
        attendance.setFirstname(request.getFirstname());
        attendance.setLastname(request.getLastname());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        attendance.setTimeAndDate((request.getTimeAndDate()));
        attendanceRepository.save(attendance);
        StudentAttendanceResponse response = new StudentAttendanceResponse();
        response.setFirstname(attendance.getFirstname());
        response.setLastname(attendance.getLastname());
        response.setMessage("Attendance Logged successfully!");
        return response;
    }

    @Override
    public List<Attendance> numberOfTimesPresent(StudentsAttendanceRequest request) {
        List<Attendance> attendanceList = new ArrayList<>();
        for(Attendance att: attendanceRepository.findAll()){
            if(att.getFirstname().equals(request.getFirstname()) && att.getLastname().equals(request.getLastname())){
                attendanceList.add(att);
            }
        }
        return attendanceList;
    }

    @Override
    public int countDaysPresent(StudentsAttendanceRequest request) {
        int count = 0;
        for(Attendance attendance : attendanceRepository.findAll()){
            if(attendance.getFirstname().equals(request.getFirstname()) && attendance.getLastname().equals(request.getLastname())){
                count++;
            }
        }
        return count;
    }

    @Override
    public StudentScoreResponse studentScoresRecord(StudentScoreRequest request) {
        scoreValidation(request.getStudentScore());
        Score score = new Score();
        score.setSubject(SubjectsOffered.BIOLOGY);
        score.setNumberOfSubjects(request.getNumberOfSubjects());
        score.setScore(request.getStudentScore());
        score.setGrade(Grade.valueOf(String.valueOf(request.getGrade())));
        scoreRepository.save(score);
        StudentScoreResponse response = new StudentScoreResponse();
        response.setScore(score.getScore());
        response.setGrade(score.getGrade());
        return response;
    }


    private void entryValidation(String username) {
        Optional<Teachers> validation = teachersRepository.findByUsername(username);
        if (validation.isPresent()) {
            throw new UsernameAlreadyExistException("found already");
        }
    }

    private void scoreValidation(int scores) {
        for(Score score : scoreRepository.findAll()){
            if(score.getScore() <= 40){
                return;
            }

            if(score.getScore() > 40 || score.getScore() <= 45){
                return;
            }

            if(score.getScore() > 45 || score.getScore() < 50){
                return;
            }
            if(score.getScore() >= 50 || score.getScore() <= 60){
                return;
            }

            if(score.getScore() >= 61 || score.getScore() <= 70){
                return;
            }
            if(score.getScore() >80){
                return;
            }
        }
    }
}


