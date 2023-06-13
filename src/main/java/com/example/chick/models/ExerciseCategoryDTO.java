package com.example.chick.models;

import com.example.chick.entity.Category;
import com.example.chick.entity.Exercise;
import com.example.chick.entity.ExerciseCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseCategoryDTO {
    private Long id;
    private CategoryDTO category;

    public static ExerciseCategoryDTO toDto(ExerciseCategory exerciseCategory) {
        ExerciseCategoryDTO exerciseCategoryDTO = new ExerciseCategoryDTO();
        exerciseCategoryDTO.setId(exerciseCategory.getId());
        exerciseCategoryDTO.setCategory(CategoryDTO.toDto(exerciseCategory.getCategory()));
        return exerciseCategoryDTO;
    }

    public static ExerciseCategory fromDto(ExerciseCategoryDTO exerciseCategoryDTO) {
        ExerciseCategory exerciseCategory = new ExerciseCategory();
        exerciseCategory.setId(exerciseCategoryDTO.getId());
        exerciseCategory.setCategory(CategoryDTO.fromDto(exerciseCategoryDTO.getCategory()));
        return exerciseCategory;
    }
}
