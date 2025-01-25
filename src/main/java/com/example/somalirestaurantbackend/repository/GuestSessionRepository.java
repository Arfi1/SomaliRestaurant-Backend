package com.example.somalirestaurantbackend.repository;

import com.example.somalirestaurantbackend.model.GuestSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestSessionRepository extends JpaRepository<GuestSession, String> {
}
