package com.example.chick.models;

import com.example.chick.entity.Category;
import com.example.chick.entity.Exercise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {
    private Long id;
    private String name;
    private String video;
    private Set<CategoryDTO> categories;

    public static ExerciseDTO toDto(Exercise exercise) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        exerciseDTO.setId(exercise.getId());
        exerciseDTO.setName(exercise.getName());
        exerciseDTO.setVideo(exercise.getVideo());
        exerciseDTO.setCategories(new HashSet<>());
        for (Category category : exercise.getCategories()) {
            exerciseDTO.getCategories().add(CategoryDTO.toDto(category));
        }
        return exerciseDTO;
    }

    public static Exercise fromDto(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();
        exercise.setId(exerciseDTO.getId());
        exercise.setName(exerciseDTO.getName());
        exercise.setVideo(exerciseDTO.getVideo());
        exercise.setCategories(new HashSet<>());
        for (CategoryDTO category : exerciseDTO.getCategories()) {
            exercise.getCategories().add(CategoryDTO.fromDto(category));
        }
        return exercise;
    }

}
