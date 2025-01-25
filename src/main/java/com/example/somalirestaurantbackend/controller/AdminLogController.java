package com.example.restaurant.controller;

import com.example.somalirestaurantbackend.model.AdminLog;
import com.example.somalirestaurantbackend.service.AdminLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/logs")
@CrossOrigin("*")
public class AdminLogController {

    private final AdminLogService adminLogService;

    public AdminLogController(AdminLogService adminLogService) {
        this.adminLogService = adminLogService;
    }

    @GetMapping
    public ResponseEntity<List<AdminLog>> getAllLogs() {
        return ResponseEntity.ok(adminLogService.getAllLogs());
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<List<AdminLog>> getLogsByAdminId(@PathVariable Integer adminId) {
        return ResponseEntity.ok(adminLogService.getLogsByAdminId(adminId));
    }
}
