package com.iLearn.iLearn.dtos.requests;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StaffAttendanceRequest {

    private Long id;
    private String firstname;
    private String lastname;
    private String time;
}
