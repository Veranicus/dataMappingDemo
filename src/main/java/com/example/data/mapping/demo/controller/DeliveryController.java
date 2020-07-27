package com.example.data.mapping.demo.controller;

import com.example.data.mapping.demo.data.entity.Delivery;
import com.example.data.mapping.demo.data.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery){
        return deliveryService.save(delivery);
    }




}
