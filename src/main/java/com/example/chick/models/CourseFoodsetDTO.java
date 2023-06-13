package com.example.chick.models;

import com.example.chick.entity.Course;
import com.example.chick.entity.CourseFoodset;
import com.example.chick.entity.Foodset;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseFoodsetDTO {
    private Long id;
    private FoodsetDTO foodset;
    private String description;
    private Integer days;
    private Integer hours;
    private Integer minutes;

    public static CourseFoodsetDTO toDto(CourseFoodset courseFoodset) {
        CourseFoodsetDTO courseFoodsetDTO = new CourseFoodsetDTO();
        courseFoodsetDTO.setId(courseFoodset.getId());
        courseFoodsetDTO.setFoodset(FoodsetDTO.toDto(courseFoodset.getFoodset()));
        courseFoodsetDTO.setDescription(courseFoodset.getDescription());
        courseFoodsetDTO.setDays(courseFoodset.getDays());
        courseFoodsetDTO.setHours(courseFoodset.getHours());
        courseFoodsetDTO.setMinutes(courseFoodset.getMinutes());
        return courseFoodsetDTO;
    }

    public static CourseFoodset fromDto(CourseFoodsetDTO courseFoodsetDTO) {
        CourseFoodset courseFoodset = new CourseFoodset();
        courseFoodset.setId(courseFoodsetDTO.getId());
        courseFoodset.setFoodset(FoodsetDTO.fromDto(courseFoodsetDTO.getFoodset()));
        courseFoodset.setDescription(courseFoodsetDTO.getDescription());
        courseFoodset.setDays(courseFoodsetDTO.getDays());
        courseFoodset.setHours(courseFoodsetDTO.getHours());
        courseFoodset.setMinutes(courseFoodsetDTO.getMinutes());
        return courseFoodset;
    }
}
