package com.example.chick.models;

import com.example.chick.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryDTO {
    private Long id;
    private CategoryDTO category;

    public static CourseCategoryDTO toDto(CourseCategory courseCategory) {
        CourseCategoryDTO courseCategoryDTO = new CourseCategoryDTO();
        courseCategoryDTO.setId(courseCategory.getId());
        courseCategoryDTO.setCategory(CategoryDTO.toDto(courseCategory.getCategory()));
        return courseCategoryDTO;
    }

    public static CourseCategory fromDto(CourseCategoryDTO courseCategoryDTO) {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(courseCategoryDTO.getId());
        courseCategory.setCategory(CategoryDTO.fromDto(courseCategoryDTO.getCategory()));
        return courseCategory;
    }
}
