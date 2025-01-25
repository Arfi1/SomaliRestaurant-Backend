package com.example.somalirestaurantbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private Boolean available;

    private String category;

    private String imageUrl; // URL eller filsti til billedet

}
