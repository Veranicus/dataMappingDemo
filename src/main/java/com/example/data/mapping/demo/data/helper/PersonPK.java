package com.example.data.mapping.demo.data.helper;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonPK implements Serializable {

    private int heightCm;

    private String sockColor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonPK personPK = (PersonPK) o;

        if (heightCm != personPK.heightCm) return false;
        return sockColor != null ? sockColor.equals(personPK.sockColor) : personPK.sockColor == null;
    }

    @Override
    public int hashCode() {
        int result = heightCm;
        result = 31 * result + (sockColor != null ? sockColor.hashCode() : 0);
        return result;
    }


    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public void setSockColor(String sockColor) {
        this.sockColor = sockColor;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public String getSockColor() {
        return sockColor;
    }
}
