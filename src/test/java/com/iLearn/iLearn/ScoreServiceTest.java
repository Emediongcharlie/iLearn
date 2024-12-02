package com.iLearn.iLearn;

import com.iLearn.iLearn.dtos.requests.StudentScoreRequest;
import com.iLearn.iLearn.dtos.response.StudentScoreResponse;
import com.iLearn.iLearn.models.Grade;
import com.iLearn.iLearn.models.Score;
import com.iLearn.iLearn.service.TeachersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.iLearn.iLearn.models.Grade.C;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ScoreServiceTest {

    @Autowired
    private TeachersService teachersService;

    @Test
    public void testStudentScoresAndGrade(){
        StudentScoreRequest request = new StudentScoreRequest();
        request.setFirstname("emedong");
        request.setLastname("emediong");
        request.setStudentScore(60);
        request.setGrade(C);
        StudentScoreResponse response = teachersService.studentScoresRecord(request);
        assertNotNull(response);
        assertEquals(C, response.getGrade());
        }
    }

