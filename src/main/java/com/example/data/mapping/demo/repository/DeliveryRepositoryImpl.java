package com.example.data.mapping.demo.repository;

import com.example.data.mapping.demo.data.entity.Delivery;
import com.example.data.mapping.demo.data.entity.Plant;
import com.example.data.mapping.demo.data.entity.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepositoryImpl implements DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    @Override
    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Override
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    @Override
    public void delete(Long id) {

        Delivery delivery = entityManager.find(Delivery.class,id);
        entityManager.remove(delivery);
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
