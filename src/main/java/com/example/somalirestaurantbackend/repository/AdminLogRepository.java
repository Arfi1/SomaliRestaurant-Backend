package com.example.somalirestaurantbackend.repository;


import com.example.somalirestaurantbackend.model.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminLogRepository extends JpaRepository<AdminLog, Integer> {
    List<AdminLog> findAllByAdminId(Integer adminId);
}
