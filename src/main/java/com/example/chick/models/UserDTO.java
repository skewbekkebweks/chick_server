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
public class UserDTO {
    private Long id;
    private String name;
    private Boolean sex;
    private Integer weight;
    private Integer height;
    private String email;
    private Boolean isAdmin;
    private Set<CategoryDTO> categories;
    private Set<ExerciseDTO> exercises;
    private Set<UserCourseDTO> userCourses;
    private Set<OrderDTO> orders;

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSex(user.getSex());
        userDTO.setWeight(user.getWeight());
        userDTO.setHeight(user.getHeight());
        userDTO.setEmail(user.getEmail());
        userDTO.setIsAdmin(user.getIsAdmin());
        userDTO.setCategories(new HashSet<>());
        for (Category category : user.getCategories()) {
            userDTO.getCategories().add(CategoryDTO.toDto(category));
        }
        userDTO.setExercises(new HashSet<>());
        for (Exercise exercise : user.getExercises()) {
            userDTO.getExercises().add(ExerciseDTO.toDto(exercise));
        }
        userDTO.setUserCourses(new HashSet<>());
        for (UserCourse userCourse : user.getUserCourses()) {
            userDTO.getUserCourses().add(UserCourseDTO.toDto(userCourse));
        }
        userDTO.setOrders(new HashSet<>());
        for (Order order : user.getOrders()) {
            userDTO.getOrders().add(OrderDTO.toDto(order));
        }
        return userDTO;
    }

    public static User fromDto(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSex(userDTO.getSex());
        user.setWeight(userDTO.getWeight());
        user.setHeight(userDTO.getHeight());
        user.setEmail(userDTO.getEmail());
        user.setIsAdmin(userDTO.getIsAdmin());
        user.setCategories(new HashSet<>());
        if (userDTO.getCategories() != null) {
            for (CategoryDTO category : userDTO.getCategories()) {
                user.getCategories().add(CategoryDTO.fromDto(category));
            }
        }
        user.setExercises(new HashSet<>());
        if (userDTO.getExercises() != null) {
            for (ExerciseDTO exercise : userDTO.getExercises()) {
                user.getExercises().add(ExerciseDTO.fromDto(exercise));
            }
        }
        user.setUserCourses(new HashSet<>());
        if (userDTO.getUserCourses() != null) {
            for (UserCourseDTO userCourse : userDTO.getUserCourses()) {
                user.getUserCourses().add(UserCourseDTO.fromDto(userCourse));
            }
        }
        user.setOrders(new HashSet<>());
        if (userDTO.getOrders() != null) {
            for (OrderDTO order : userDTO.getOrders()) {
                user.getOrders().add(OrderDTO.fromDto(order));
            }
        }
        return user;
    }
}
