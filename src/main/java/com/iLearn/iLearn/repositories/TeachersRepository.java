package com.iLearn.iLearn.repositories;

import com.iLearn.iLearn.models.Student;
import com.iLearn.iLearn.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {


    Optional<Teachers> findByUsername(String username);
}
