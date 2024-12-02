package com.iLearn.iLearn;

import com.iLearn.iLearn.dtos.requests.StudentsAttendanceRequest;
import com.iLearn.iLearn.dtos.requests.TeachersRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentAttendanceResponse;
import com.iLearn.iLearn.dtos.response.TeachersRegistrationResponse;
import com.iLearn.iLearn.models.Attendance;
import com.iLearn.iLearn.models.ClassLevel;
import com.iLearn.iLearn.models.SubjectsOffered;
import com.iLearn.iLearn.service.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class TeachersServiceTest {

    @Autowired
   private TeachersService teachersService;

    @Test
    public void testTeachersCanRegister() {
        TeachersRegistrationRequest request = new TeachersRegistrationRequest();
        request.setUsername("JamesJojo");
        request.setTeachersName("John James");
        request.setSubjectHandled(SubjectsOffered.valueOf(SubjectsOffered.BIOLOGY.toString()));
        log.info("Registering teachers: {}", request);
        request.setTeachersBio("He is an experienced teacher");
        TeachersRegistrationResponse response = teachersService.register(request);
        assertNotNull(response);
        assertEquals("Successfully registered!", response.getMessage());
    }

    @Test
    public void testTeacherCanTakeAttendance(){
        StudentsAttendanceRequest request = new StudentsAttendanceRequest();
        request.setFirstname("emediong");
        request.setLastname("emediong");
        request.setTimeAndDate(LocalDateTime.now());
        StudentAttendanceResponse response = teachersService.attendanceRecord(request);
        assertNotNull(response);
    }

    @Test
    public void testToCountSelectDaysPresentInSchool(){
        StudentsAttendanceRequest request = new StudentsAttendanceRequest();
        request.setFirstname("emediong");
        request.setArm(ClassLevel.PRIMARYSIX);
        List<Attendance> response = teachersService.numberOfTimesPresent(request);
        assertNotNull(response);
    }

    @Test
    public void testCountNumberOfDaysPresent(){
        StudentsAttendanceRequest request = new StudentsAttendanceRequest();
        request.setFirstname("emediong");
        request.setLastname("emediong");
        int response = teachersService.countDaysPresent(request);
        assertNotNull(response);
        assertEquals(response,4);
    }
}
