package com.example.chick.models;

import com.example.chick.entity.Order;
import com.example.chick.entity.OrderFoodset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Date date;
    private StoreDTO store;
    private Set<OrderFoodsetDTO> orderFoodsets;

    public static OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setStore(StoreDTO.toDto(order.getStore()));
        orderDTO.setOrderFoodsets(new HashSet<>());
        for (OrderFoodset orderFoodset : order.getOrderFoodsets()) {
            orderDTO.getOrderFoodsets().add(OrderFoodsetDTO.toDto(orderFoodset));
        }
        return orderDTO;
    }

    public static Order fromDto(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDate(orderDTO.getDate());
        order.setStore(StoreDTO.fromDto(orderDTO.getStore()));
        order.setOrderFoodsets(new HashSet<>());
        for (OrderFoodsetDTO orderFoodset : orderDTO.getOrderFoodsets()) {
            OrderFoodset set = OrderFoodsetDTO.fromDto(orderFoodset);
            set.setOrder(order);
            order.getOrderFoodsets().add(set);
        }
        return order;
    }
}
