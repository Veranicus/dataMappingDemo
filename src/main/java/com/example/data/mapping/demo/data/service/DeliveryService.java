package com.example.data.mapping.demo.data.service;

import com.example.data.mapping.demo.data.entity.Delivery;
import com.example.data.mapping.demo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Long save(Delivery delivery){
        delivery.getPlantsForDelivery().forEach(
                plant -> plant.setDelivery(delivery)
        );
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
