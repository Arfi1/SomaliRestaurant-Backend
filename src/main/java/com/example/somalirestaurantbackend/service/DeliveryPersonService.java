package com.example.somalirestaurantbackend.service;

import com.example.somalirestaurantbackend.model.DeliveryPerson;
import com.example.somalirestaurantbackend.repository.DeliveryPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPersonService(DeliveryPersonRepository deliveryPersonRepository) {
        this.deliveryPersonRepository = deliveryPersonRepository;
    }

    public List<DeliveryPerson> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    public DeliveryPerson saveDeliveryPerson(DeliveryPerson deliveryPerson) {
        return deliveryPersonRepository.save(deliveryPerson);
    }

    public void deleteDeliveryPerson(Integer id) {
        deliveryPersonRepository.deleteById(id);
    }
}
