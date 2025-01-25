package com.example.somalirestaurantbackend.repository;


import com.example.somalirestaurantbackend.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Integer> {
}
