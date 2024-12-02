package com.iLearn.iLearn;


import com.iLearn.iLearn.dtos.requests.StudentRegistrationRequest;
import com.iLearn.iLearn.dtos.requests.TeachersRegistrationRequest;
import com.iLearn.iLearn.dtos.response.StudentRegistrationResponse;
import com.iLearn.iLearn.dtos.response.TeachersRegistrationResponse;
import com.iLearn.iLearn.models.ClassLevel;
import com.iLearn.iLearn.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testStudentCanRegister() {
        StudentRegistrationRequest request = new StudentRegistrationRequest();
        request.setUsername("fith");
        request.setFirstName("emediong");
        request.setLastName("emediong");
        request.setArm(ClassLevel.PRIMARYTWO);
        StudentRegistrationResponse response = studentService.register(request);
        assertNotNull(response);
        assertEquals("Registered Successfully", response.getMessage());
    }

}
