package com.example.data.mapping.demo.repository;

import com.example.data.mapping.demo.data.entity.Outfit;
import com.example.data.mapping.demo.data.inheritanceentity.Humanoid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanoidRepository extends JpaRepository<Humanoid, Long> {

    List<Humanoid> findAllByOutfitsHat(String hat);


    @Query("select h from Humanoid h where :outfit member  of h.outfits")
    List<Humanoid> findAllByOutfit(@Param(("outfit")) Outfit outfit);

    //Does the same as above
    List<Humanoid> findAllByOutfitsContaining(Outfit outfit);


    //    Automatically uses query named Humanoid.findAllNamedQuery
    List<Humanoid> findAllNamedQuery(Outfit outfit);


}
