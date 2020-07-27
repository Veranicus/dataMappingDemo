package com.example.data.mapping.demo.data.inheritanceentity;

import com.example.data.mapping.demo.data.entity.Outfit;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Humanoid.findAllNamedQuery", query = "select h from Humanoid h where :outfit member of h.outfits")
public abstract class Humanoid {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "humanoid")
    List<Outfit> outfits;

    /* getters and setters */
}
