package com.example.chick.controllers;

import com.example.chick.entity.Exercise;
import com.example.chick.repo.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ExerciseController {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping("/exercise")
    public ArrayList<Exercise> getExercises() {
        return (ArrayList<Exercise>) exerciseRepository.findAll();
    }

}
