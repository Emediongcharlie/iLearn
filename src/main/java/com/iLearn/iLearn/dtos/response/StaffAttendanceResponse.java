package com.iLearn.iLearn.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class StaffAttendanceResponse {

    private String firstname;
    private String lastname;
    private String time;
    private String message;
}
