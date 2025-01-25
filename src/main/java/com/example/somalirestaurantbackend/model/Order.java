package com.example.somalirestaurantbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    @ManyToMany
    @JoinTable(
            name = "order_menu_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;

    private Double totalPrice;

    private String orderStatus; // "PENDING", "IN_PROGRESS", "DELIVERED"

    private String assignedDeliveryPerson;

    private LocalDateTime orderDate;
}
