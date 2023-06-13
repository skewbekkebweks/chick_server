package com.example.chick.models;

import com.example.chick.entity.Course;
import com.example.chick.entity.User;
import com.example.chick.entity.UserCourse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseDTO {
    private Long id;
    private CourseDTO course;
    private Date startDate;
    private Boolean isCompleted;

    public static UserCourseDTO toDto(UserCourse userCourse) {
        UserCourseDTO userCourseDTO = new UserCourseDTO();
        userCourseDTO.setId(userCourse.getId());
        userCourseDTO.setCourse(CourseDTO.toDto(userCourse.getCourse()));
        userCourseDTO.setStartDate(userCourse.getStartDate());
        userCourseDTO.setIsCompleted(userCourse.getIsCompleted());
        return userCourseDTO;
    }

    public static UserCourse fromDto(UserCourseDTO userCourseDTO) {
        UserCourse userCourse = new UserCourse();
        userCourse.setId(userCourseDTO.getId());
        userCourse.setCourse(CourseDTO.fromDto(userCourseDTO.getCourse()));
        userCourse.setStartDate(userCourseDTO.getStartDate());
        userCourse.setIsCompleted(userCourseDTO.getIsCompleted());
        return userCourse;
    }
}
