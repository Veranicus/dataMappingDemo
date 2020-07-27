package com.example.data.mapping.demo.data.EntityManager;

import com.example.data.mapping.demo.data.entity.Outfit;
import com.example.data.mapping.demo.data.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class PersistentContextTest {

    @PersistenceContext
    EntityManager entityManager;

    public void persistExample(Person person) {
        entityManager.persist(person);
        person.setAge(40);
    }

    public void findExample(Long id) {
        Person person = entityManager.find(Person.class, id);
        person.setFavoriteComposer("Bach");
    }

    public void getReferenceExample(Long personId, Long outfitId) {
        Person person = entityManager.find(Person.class, personId);
        Outfit outfitReference = entityManager.getReference(Outfit.class, outfitId);
        person.getOutfits().add(outfitReference);
    }

    public void mergeExample(Person detachedPerson){
        detachedPerson.setFavoriteComposer("Mozart");
        Person managedPerson = entityManager.merge(detachedPerson);
        detachedPerson.setFavoriteComposer("Antonio Salieiri"); //Will hav eno effect on the database
        managedPerson.setFavoriteComposer("C.P.E Bach"); //will overwrite Mozart

    }

    public void deleteExample(Long id){
        Person person = entityManager.find(Person.class,id);
        entityManager.remove(person);
    }



}
