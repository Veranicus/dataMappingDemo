package com.example.data.mapping.demo.data.entity;

import com.example.data.mapping.demo.data.helper.PersonPK;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @EmbeddedId
    PersonPK id;

////    With mapped by we have a foreign key of person in the outfit table.
//    @OneToOne(mappedBy = "person")
//    @JoinColumn(name = "outfit_column")
//    private Outfit outfit;

    @Nationalized
    private String name;

    private int age;

    @Column(name = "composer",length = 512)
    private String favoriteComposer;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_outfit",
    joinColumns = {@JoinColumn(name = "person_id")},
    inverseJoinColumns = {@JoinColumn(name = "outfit_id")})
    private List<Outfit> outfits;

    public PersonPK getId() {
        return id;
    }

    public void setId(PersonPK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteComposer() {
        return favoriteComposer;
    }

    public void setFavoriteComposer(String favoriteComposer) {
        this.favoriteComposer = favoriteComposer;
    }

//    public Outfit getOutfit() {
//        return outfit;
//    }

    public List<Outfit> getOutfits() {
        return outfits;
    }
}
