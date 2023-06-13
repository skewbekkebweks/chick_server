package com.example.chick.repo;

import com.example.chick.entity.FoodsetProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsetProductRepository extends JpaRepository<FoodsetProduct, Long> {
}