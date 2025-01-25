package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.AddressVerification;
import com.example.somalirestaurantbackend.repository.AddressVerificationRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressVerificationService {

    private final AddressVerificationRepository addressVerificationRepository;

    public AddressVerificationService(AddressVerificationRepository addressVerificationRepository) {
        this.addressVerificationRepository = addressVerificationRepository;
    }

    public AddressVerification verifyAddress(AddressVerification address) {
        // Her skal WebClient eller geokodnings-API implementeres.
        address.setVerificationStatus(true); // Midlertidig status for succes.
        address.setLatitude(0.0); // Dummy-data, indtil API-integration.
        address.setLongitude(0.0);
        return addressVerificationRepository.save(address);
    }
}
