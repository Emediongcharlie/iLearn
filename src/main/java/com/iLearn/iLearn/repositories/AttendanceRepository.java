package com.iLearn.iLearn.repositories;

import com.iLearn.iLearn.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}
