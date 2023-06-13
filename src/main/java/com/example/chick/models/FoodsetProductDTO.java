package com.example.chick.models;

import com.example.chick.entity.Foodset;
import com.example.chick.entity.FoodsetProduct;
import com.example.chick.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodsetProductDTO {
    private Long id;
    private ProductDTO product;
    private Integer count;
    private Integer weight;

    public static FoodsetProductDTO toDto(FoodsetProduct foodsetProduct) {
        FoodsetProductDTO foodsetProductDTO = new FoodsetProductDTO();
        foodsetProductDTO.setId(foodsetProduct.getId());
        foodsetProductDTO.setProduct(ProductDTO.toDto(foodsetProduct.getProduct()));
        foodsetProductDTO.setCount(foodsetProduct.getCount());
        foodsetProductDTO.setWeight(foodsetProduct.getWeight());
        return foodsetProductDTO;
    }

    public static FoodsetProduct fromDto(FoodsetProductDTO foodsetProductDTO) {
        FoodsetProduct foodsetProduct = new FoodsetProduct();
        foodsetProduct.setId(foodsetProductDTO.getId());
        foodsetProduct.setProduct(ProductDTO.fromDto(foodsetProductDTO.getProduct()));
        foodsetProduct.setCount(foodsetProductDTO.getCount());
        foodsetProduct.setWeight(foodsetProductDTO.getWeight());
        return foodsetProduct;
    }
}
