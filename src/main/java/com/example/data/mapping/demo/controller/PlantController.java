package com.example.data.mapping.demo.controller;

import com.example.data.mapping.demo.data.entity.Plant;
import com.example.data.mapping.demo.data.entity.PlantDto;
import com.example.data.mapping.demo.data.helper.Views;
import com.example.data.mapping.demo.data.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {


    private PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }


/*    public PlantDto getPlantDto(String name) {
        Plant plant = plantService.getPlantByName("s");
        return convertPlantToPlantDto(plant);
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name) {
        return plantService.getPlantByName("test");
    }*/

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return plantService.findPlantsBelowPrice(price);
    }

    private PlantDto convertPlantToPlantDto(Plant plant) {
        PlantDto plantDto = new PlantDto();
        BeanUtils.copyProperties(plant, plantDto);
        return plantDto;

    }


}
