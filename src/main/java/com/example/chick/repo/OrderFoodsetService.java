package com.example.chick.repo;


import com.example.chick.entity.OrderFoodset;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodsetService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityManager(OrderFoodset of) {
        entityManager.createNativeQuery("INSERT INTO order_foodsets (order_id, foodset_id, coefficient) VALUES (?,?,?)")
                .setParameter(1, of.getOrder().getId())
                .setParameter(2, of.getFoodset().getId())
                .setParameter(3, of.getCoefficient())
                .executeUpdate();
    }
}
