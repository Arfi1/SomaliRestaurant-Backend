package com.example.somalirestaurantbackend.repository;


import com.example.somalirestaurantbackend.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
