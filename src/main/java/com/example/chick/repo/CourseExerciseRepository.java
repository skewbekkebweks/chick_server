package com.example.chick.repo;

import com.example.chick.entity.CourseExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseExerciseRepository extends JpaRepository<CourseExercise, Long> {
}