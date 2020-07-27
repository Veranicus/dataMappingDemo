package com.example.data.mapping.demo.data.inheritanceentity;

import javax.persistence.Entity;

@Entity
public class CreepyDepartmentStoreMannequin extends Humanoid {

    private boolean hasAHead;
    private MannequinShape mannequinShape;

    enum MannequinShape {
        LITHE, MUSCULUR, UNASSUMING;
    }

    /* getters and setters */
}