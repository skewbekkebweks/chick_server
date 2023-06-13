package com.example.chick.repo;

import com.example.chick.entity.OrderFoodset;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodsetRepository extends JpaRepository<OrderFoodset, Long> {
}