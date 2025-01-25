package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.MenuItem;
import com.example.somalirestaurantbackend.model.Order;
import com.example.somalirestaurantbackend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order saveOrder(Order order) {
        double totalPrice = order.getMenuItems().stream().mapToDouble(MenuItem::getPrice).sum();
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Integer id, String status) {
        Order existingOrder = getOrderById(id);
        existingOrder.setOrderStatus(status);
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
