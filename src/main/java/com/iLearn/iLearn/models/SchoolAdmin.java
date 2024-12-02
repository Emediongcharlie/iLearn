package com.iLearn.iLearn.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter@Getter
public class SchoolAdmin {

    private String schoolName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schoolAddress;
    private String firstname;
    private String lastname;
    private String schoolEmail;
    private String schoolPhone;
    @OneToMany
    private List<Report> studentReport;
    @OneToMany
    private List<Attendance> teachersAttendance;
    private StaffRole classAssignment;
    private ClassLevel setClassLevelArm;
}
