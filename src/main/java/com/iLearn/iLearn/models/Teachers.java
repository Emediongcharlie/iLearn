package com.iLearn.iLearn.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teachersName;
    private String username;
    private SubjectsOffered subjectHandled;
    private String teachersBio;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Attendance studentAttendance;
    @OneToOne
    private Score studentScore;
    @OneToOne
    private Position studentPosition;

}
