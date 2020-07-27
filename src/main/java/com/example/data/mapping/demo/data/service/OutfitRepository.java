package com.example.data.mapping.demo.data.service;

import com.example.data.mapping.demo.data.entity.Outfit;
import org.springframework.data.repository.CrudRepository;

public interface OutfitRepository extends CrudRepository<Outfit,Long>{

    Outfit findByHat(String hat);

    Outfit findByHatAndShoes(String hat, String shoes);

//    Spring data generates from method signature JPQL

}
