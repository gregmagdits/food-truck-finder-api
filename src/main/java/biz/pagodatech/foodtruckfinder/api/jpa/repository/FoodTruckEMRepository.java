package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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


    public void createFoodTruckReview(User user, FoodTruckEntity truckEntity, Long rating, String review) {
        FoodTruckReviewEntity e = new FoodTruckReviewEntity(rating, review, user, truckEntity);
        em.persist(e);
    }

    public void createFoodItemReview(User user, FoodItemEntity foodItemEntity, Long rating, String review) {
        FoodItemReviewEntity e = new FoodItemReviewEntity(rating, review, user, foodItemEntity);
        em.persist(e);
    }

    public void createFoodItemLike(User user, FoodItemEntity foodItemEntity) {
        FoodItemLikesEntity e = new FoodItemLikesEntity(user, foodItemEntity);
        em.persist(e);
    }

    public void createFoodTruckLike(User user, FoodTruckEntity foodTruckEntity) {
        FoodTruckLikesEntity e = new FoodTruckLikesEntity(user, foodTruckEntity);
        em.persist(e);
    }
}