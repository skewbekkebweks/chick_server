package com.example.chick.repo;

import com.example.chick.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findByDate(Date date);
}