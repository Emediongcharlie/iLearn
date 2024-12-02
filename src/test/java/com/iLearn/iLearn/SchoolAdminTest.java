package com.iLearn.iLearn;

import com.iLearn.iLearn.dtos.requests.SchoolAdminRequest;
import com.iLearn.iLearn.dtos.response.SchoolAdminResponse;
import com.iLearn.iLearn.models.ClassLevel;
import com.iLearn.iLearn.service.SchoolAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SchoolAdminTest {

    @Autowired
    private SchoolAdminService adminService;


    @Test
    public void testThatTheStudentCanBeAssignedToAClass(){
        SchoolAdminRequest request = new SchoolAdminRequest();
        request.setFirstname("James");
        request.setLastname("Bond");
        request.setSetClassLevelArm(ClassLevel.PRIMARYTWO);
        SchoolAdminResponse response = adminService.assignedClass(request);
        assertNotNull(response);

    }
}
