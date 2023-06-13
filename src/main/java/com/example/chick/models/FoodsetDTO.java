package com.example.chick.models;

import com.example.chick.entity.Foodset;
import com.example.chick.entity.FoodsetProduct;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodsetDTO {
    private Long id;
    private Set<FoodsetProductDTO> foodsetProducts;

    public static FoodsetDTO toDto(Foodset foodset) {
        FoodsetDTO foodsetDTO = new FoodsetDTO();
        foodsetDTO.setId(foodset.getId());
        foodsetDTO.setFoodsetProducts(new HashSet<>());
        for (FoodsetProduct foodsetProduct : foodset.getFoodsetProducts()) {
            foodsetDTO.getFoodsetProducts().add(FoodsetProductDTO.toDto(foodsetProduct));
        }
        return foodsetDTO;
    }

    public static Foodset fromDto(FoodsetDTO foodsetDTO) {
        Foodset foodset = new Foodset();
        foodset.setId(foodsetDTO.getId());
        foodset.setFoodsetProducts(new HashSet<>());
        for (FoodsetProductDTO foodsetProduct : foodsetDTO.getFoodsetProducts()) {
            foodset.getFoodsetProducts().add(FoodsetProductDTO.fromDto(foodsetProduct));
        }
        return foodset;
    }
}
