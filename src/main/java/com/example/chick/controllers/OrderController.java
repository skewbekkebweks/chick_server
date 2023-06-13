package com.example.chick.controllers;

import com.example.chick.entity.*;
import com.example.chick.jwt.AuthService;
import com.example.chick.jwt.JwtAuthentication;
import com.example.chick.models.OrderDTO;
import com.example.chick.models.StoreDTO;
import com.example.chick.repo.*;
import com.example.chick.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    private final StoreRepository storeRepository;

    private final OrderFoodsetRepository orderFoodsetRepository;
    private final FoodsetRepository foodsetRepository;
    private final OrderFoodsetService orderFoodsetService;

    private final UserRepository userRepository;

    private final AuthService authService;

    @PostMapping("/order")
    public OrderDTO saveOrder(@RequestBody OrderRequest order) {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        Optional<User> user = userRepository.findByEmail(authInfo.getEmail());
        if (!user.isPresent()) return null;
        User u = user.get();
        Order o = new Order();
        o.setDate(new Date());
        o.setUser(u);
        o.setOrderFoodsets(new HashSet<>());
        for (long foodsetId : order.getFoodsetsId()) {
            OrderFoodset orderFoodset = new OrderFoodset();
            orderFoodset.setCoefficient(1.0);
            orderFoodset.setOrder(o);
            Optional<Foodset> foodsetO = foodsetRepository.findById(foodsetId);
            foodsetO.ifPresent(orderFoodset::setFoodset);
            o.getOrderFoodsets().add(orderFoodset);
        }
        Store s = StoreDTO.fromDto(order.getStore());
        if (storeRepository.countByYaId(s.getYaId()) == 0) s = storeRepository.save(s);
        else s = storeRepository.findByYaId(s.getYaId());
        o.setStore(s);
        o = orderRepository.save(o);

        for (OrderFoodset orderFoodset : o.getOrderFoodsets()) {
            orderFoodsetService.insertWithEntityManager(orderFoodset);
        }
        return OrderDTO.toDto(o);
    }
}
