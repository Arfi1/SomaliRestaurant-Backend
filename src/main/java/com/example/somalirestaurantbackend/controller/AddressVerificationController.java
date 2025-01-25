package com.example.somalirestaurantbackend.controller;

import com.example.somalirestaurantbackend.model.AddressVerification;
import com.example.somalirestaurantbackend.service.AddressVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verify-address")
@CrossOrigin("*")
public class AddressVerificationController {

    private final AddressVerificationService addressVerificationService;

    @Autowired
    public AddressVerificationController(AddressVerificationService addressVerificationService) {
        this.addressVerificationService = addressVerificationService;
    }

    @PostMapping
    public ResponseEntity<AddressVerification> verifyAddress(@RequestBody AddressVerification address) {
        return ResponseEntity.ok(addressVerificationService.verifyAddress(address));
    }
}
