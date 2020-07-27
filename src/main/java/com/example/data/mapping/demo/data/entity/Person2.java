package com.example.data.mapping.demo.data.entity;

import com.example.data.mapping.demo.data.helper.PersonPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonPK.class)
public class Person2 {

    @Id
    private int heightCm;

    @Id
    private String sockColor;

    public PersonPK getId() {
        PersonPK id = new PersonPK();

        id.setHeightCm(heightCm);
        id.setSockColor(sockColor);
        return id;
    }

    public void setId(PersonPK id) {
        this.heightCm = id.getHeightCm();
        this.sockColor = id.getSockColor();
    }
}
