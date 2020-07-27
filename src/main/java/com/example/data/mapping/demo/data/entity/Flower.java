package com.example.data.mapping.demo.data.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Entity;

@Entity
public class Flower extends Plant {


    @Nationalized
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
