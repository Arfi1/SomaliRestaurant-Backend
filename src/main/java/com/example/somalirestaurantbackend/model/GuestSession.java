package com.example.somalirestaurantbackend.model;

import com.example.somalirestaurantbackend.model.MenuItem;
import com.example.somalirestaurantbackend.model.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class GuestSession {

    @Id
    private String sessionId; // Generate a UUID for this in the service layer

    @ManyToMany
    @JoinTable(
            name = "guest_session_menu_items",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;

    @OneToOne
    private Order orderDetails;

    private LocalDateTime createdAt;
}
