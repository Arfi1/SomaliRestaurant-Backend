package com.example.somalirestaurantbackend.repository;

import com.example.somalirestaurantbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
