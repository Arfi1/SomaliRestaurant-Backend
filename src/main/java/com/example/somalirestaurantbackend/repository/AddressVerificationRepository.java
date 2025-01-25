package com.example.somalirestaurantbackend.repository;

import com.example.somalirestaurantbackend.model.AddressVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressVerificationRepository extends JpaRepository<AddressVerification, Integer> {
}
