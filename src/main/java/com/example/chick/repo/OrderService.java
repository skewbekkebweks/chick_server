package com.example.chick.repo;

import com.example.chick.entity.Order;
import com.example.chick.entity.OrderFoodset;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityManager(Order order) {
        entityManager.createNativeQuery("INSERT INTO order (date, store_id, user_id) VALUES (?,?,?)")
                .setParameter(1, order.getDate())
                .setParameter(2, order.getStore().getYaId())
                .setParameter(3, order.getUser().getId())
                .executeUpdate();
    }
}
