package com.iLearn.iLearn.repositories;

import com.iLearn.iLearn.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
