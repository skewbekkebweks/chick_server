package com.example.chick.models;

import com.example.chick.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private Set<CategoryDTO> categories;
    private Set<CourseFoodsetDTO> courseFoodsets;
    private Set<CourseExerciseDTO> courseExercises;

    public static CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setDuration(course.getDuration());
        courseDTO.setCategories(new HashSet<>());
        for (Category category : course.getCategories()) {
            courseDTO.getCategories().add(CategoryDTO.toDto(category));
        }
        courseDTO.setCourseFoodsets(new HashSet<>());
        for (CourseFoodset courseFoodset : course.getCourseFoodsets()) {
            courseDTO.getCourseFoodsets().add(CourseFoodsetDTO.toDto(courseFoodset));
        }
        courseDTO.setCourseExercises(new HashSet<>());
        for (CourseExercise courseExercise : course.getCourseExercises()) {
            courseDTO.getCourseExercises().add(CourseExerciseDTO.toDto(courseExercise));
        }
        return courseDTO;
    }

    public static Course fromDto(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        course.setCategories(new HashSet<>());
        for (CategoryDTO category : courseDTO.getCategories()) {
            course.getCategories().add(CategoryDTO.fromDto(category));
        }
        course.setCourseFoodsets(new HashSet<>());
        for (CourseFoodsetDTO courseFoodset : courseDTO.getCourseFoodsets()) {
            course.getCourseFoodsets().add(CourseFoodsetDTO.fromDto(courseFoodset));
        }
        course.setCourseExercises(new HashSet<>());
        for (CourseExerciseDTO courseExercise : courseDTO.getCourseExercises()) {
            course.getCourseExercises().add(CourseExerciseDTO.fromDto(courseExercise));
        }
        return course;
    }

}
