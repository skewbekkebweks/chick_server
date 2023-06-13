package com.example.chick.repo;

import com.example.chick.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(int id);

    public User findByEmailAndPassword(String email, String password);

    public Optional<User> findByEmail(String email);

    public long countByEmail(String email);
}