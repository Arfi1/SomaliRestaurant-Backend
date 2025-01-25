package com.example.somalirestaurantbackend.repository;


import com.example.somalirestaurantbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerName(String customerName);
}
