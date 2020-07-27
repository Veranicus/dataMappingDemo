package com.example.data.mapping.demo.data.inheritanceentity;

import com.example.data.mapping.demo.data.entity.Outfit;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class HumanoidJoined {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "humanoid")
    List<Outfit> outfits;

    /* getters and setters */
}