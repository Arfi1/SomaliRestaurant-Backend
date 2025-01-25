package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.AdminLog;
import com.example.somalirestaurantbackend.repository.AdminLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogService {

    private final AdminLogRepository adminLogRepository;

    public AdminLogService(AdminLogRepository adminLogRepository) {
        this.adminLogRepository = adminLogRepository;
    }

    public List<AdminLog> getAllLogs() {
        return adminLogRepository.findAll();
    }

    public List<AdminLog> getLogsByAdminId(Integer adminId) {
        return adminLogRepository.findAllByAdminId(adminId);
    }
}
