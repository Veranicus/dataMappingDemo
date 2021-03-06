package com.example.data.mapping.demo.repository;

import com.example.data.mapping.demo.data.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {


    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    //you can return a primitive directly
    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);


    List<Plant> findPlantsByPriceLessThan(BigDecimal price);
}
