package com.example.somalirestaurantbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AddressVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String originalAddress;

    private String verifiedAddress;

    private Double latitude;

    private Double longitude;

    private Boolean verificationStatus;
}
