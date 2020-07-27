package com.example.data.mapping.demo.repository;

import com.example.data.mapping.demo.data.entity.Delivery;
import com.example.data.mapping.demo.data.entity.RecipientAndPrice;

public interface DeliveryRepository {

    void persist(Delivery delivery);

    Delivery find(Long id);

    Delivery merge(Delivery delivery);

    void delete(Long id);

    RecipientAndPrice getBill(Long deliveryId);

}
