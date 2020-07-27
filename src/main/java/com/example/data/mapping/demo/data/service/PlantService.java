package com.example.data.mapping.demo.data.service;

import com.example.data.mapping.demo.data.entity.Plant;
import com.example.data.mapping.demo.repository.DeliveryRepository;
import com.example.data.mapping.demo.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    PlantRepository plantRepository;
    DeliveryRepository deliveryRepository;

    public PlantService(PlantRepository plantRepository, DeliveryRepository deliveryRepository) {
        this.plantRepository = plantRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public Plant save(Plant plant){
        return plantRepository.save(plant);
    }

    public Boolean delivered(Long id){
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findPlantsByPriceLessThan(price);
    }


}
