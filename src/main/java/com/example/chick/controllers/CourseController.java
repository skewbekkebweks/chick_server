package com.example.chick.controllers;

import com.example.chick.models.CourseDTO;
import com.example.chick.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/course")
    public Stream<CourseDTO> getCourses() {
        return courseRepository.findAll().stream().map(CourseDTO::toDto);
    }
}
