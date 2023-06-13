package com.example.chick.repo;

import com.example.chick.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public long countByYaId(Long id);
    public Store findByYaId(Long id);
}
