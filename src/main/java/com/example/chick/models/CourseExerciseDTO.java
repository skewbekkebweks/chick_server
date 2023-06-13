package com.example.chick.models;

import com.example.chick.entity.Course;
import com.example.chick.entity.CourseExercise;
import com.example.chick.entity.Exercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseExerciseDTO {
    private Long id;
    private ExerciseDTO exercise;
    private String description;
    private Integer days;
    private Integer hours;
    private Integer minutes;

    public static CourseExerciseDTO toDto(CourseExercise courseExercise) {
        CourseExerciseDTO courseExerciseDTO = new CourseExerciseDTO();
        courseExerciseDTO.setId(courseExercise.getId());
        courseExerciseDTO.setExercise(ExerciseDTO.toDto(courseExercise.getExercise()));
        courseExerciseDTO.setDescription(courseExercise.getDescription());
        courseExerciseDTO.setDays(courseExercise.getDays());
        courseExerciseDTO.setHours(courseExercise.getHours());
        courseExerciseDTO.setMinutes(courseExercise.getMinutes());
        return courseExerciseDTO;
    }

    public static CourseExercise fromDto(CourseExerciseDTO courseExerciseDTO) {
        CourseExercise courseExercise = new CourseExercise();
        courseExercise.setId(courseExerciseDTO.getId());
        courseExercise.setExercise(ExerciseDTO.fromDto(courseExerciseDTO.getExercise()));
        courseExercise.setDescription(courseExerciseDTO.getDescription());
        courseExercise.setDays(courseExerciseDTO.getDays());
        courseExercise.setHours(courseExerciseDTO.getHours());
        courseExercise.setMinutes(courseExerciseDTO.getMinutes());
        return courseExercise;
    }
}
