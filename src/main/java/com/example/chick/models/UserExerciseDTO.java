package com.example.chick.models;

import com.example.chick.entity.Exercise;
import com.example.chick.entity.User;
import com.example.chick.entity.UserExercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExerciseDTO {
    private Long id;
    private ExerciseDTO exercise;

    public static UserExerciseDTO toDto(UserExercise userExercise) {
        UserExerciseDTO userExerciseDTO = new UserExerciseDTO();
        userExerciseDTO.setId(userExercise.getId());
        userExerciseDTO.setExercise(ExerciseDTO.toDto(userExercise.getExercise()));
        return userExerciseDTO;
    }

    public static UserExercise fromDto(UserExerciseDTO userExerciseDTO) {
        UserExercise userExercise = new UserExercise();
        userExercise.setId(userExerciseDTO.getId());
        userExercise.setExercise(ExerciseDTO.fromDto(userExerciseDTO.getExercise()));
        return userExercise;
    }
}
