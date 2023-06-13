package com.example.chick.models;

import com.example.chick.entity.Foodset;
import com.example.chick.entity.Order;
import com.example.chick.entity.OrderFoodset;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodsetDTO {
    private Long id;
    private FoodsetDTO foodset;
    private Double coefficient;

    public static OrderFoodsetDTO toDto(OrderFoodset orderFoodset) {
        OrderFoodsetDTO orderFoodsetDTO = new OrderFoodsetDTO();
        orderFoodsetDTO.setId(orderFoodset.getId());
        orderFoodsetDTO.setFoodset(FoodsetDTO.toDto(orderFoodset.getFoodset()));
        orderFoodsetDTO.setCoefficient(orderFoodset.getCoefficient());
        return orderFoodsetDTO;
    }

    public static OrderFoodset fromDto(OrderFoodsetDTO orderFoodsetDTO) {
        OrderFoodset orderFoodset = new OrderFoodset();
        orderFoodset.setId(orderFoodsetDTO.getId());
        orderFoodset.setFoodset(FoodsetDTO.fromDto(orderFoodsetDTO.getFoodset()));
        orderFoodset.setCoefficient(orderFoodsetDTO.getCoefficient());
        return orderFoodset;
    }
}
