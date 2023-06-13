package com.example.chick.repo;

import com.example.chick.entity.Foodset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodsetRepository extends JpaRepository<Foodset, Long> {
}