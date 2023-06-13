package com.example.chick.models;

import com.example.chick.entity.Category;
import com.example.chick.entity.User;
import com.example.chick.entity.UserCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCategoryDTO {
    private Long id;
    private CategoryDTO category;

    public static UserCategoryDTO toDto(UserCategory userCategory) {
        UserCategoryDTO userCategoryDTO = new UserCategoryDTO();
        userCategoryDTO.setId(userCategory.getId());
        userCategoryDTO.setCategory(CategoryDTO.toDto(userCategory.getCategory()));
        return userCategoryDTO;
    }

    public static UserCategory fromDto(UserCategoryDTO userCategoryDTO) {
        UserCategory userCategory = new UserCategory();
        userCategory.setId(userCategoryDTO.getId());
        userCategory.setCategory(CategoryDTO.fromDto(userCategoryDTO.getCategory()));
        return userCategory;
    }
}
