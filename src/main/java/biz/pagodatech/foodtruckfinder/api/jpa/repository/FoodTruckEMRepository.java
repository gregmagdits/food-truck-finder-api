package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class FoodTruckEMRepository {
    private EntityManager em;

    public List<FoodTruckEntity> getFoodTrucks(){
        EntityGraph entityGraph = em.getEntityGraph("food-truck-with-items-fully-populated");
        return em.createQuery("SELECT f FROM FoodTruckEntity f", FoodTruckEntity.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}