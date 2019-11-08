package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.auth.CognitoPrincipal;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemLikesEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemReviewEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckLikesEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckReviewEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@AllArgsConstructor
public class FoodTruckEMRepository {
    private EntityManager em;
    private AppUserRepository userRepo;

    public List<FoodTruckEntity> getFoodTrucks(){
        EntityGraph entityGraph = em.getEntityGraph("food-truck-with-items-fully-populated");
        return em.createQuery("SELECT f FROM FoodTruckEntity f", FoodTruckEntity.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }


    public void createFoodTruckReview(CognitoPrincipal user, FoodTruckEntity truckEntity, Long rating, String review) {
        FoodTruckReviewEntity e = new FoodTruckReviewEntity(rating, review, user.getDetails().getUsername(), truckEntity);
        em.persist(e);
    }

    public void createFoodItemReview(CognitoPrincipal user, FoodItemEntity foodItemEntity, Long rating, String review) {
        FoodItemReviewEntity e = new FoodItemReviewEntity(rating, review, user.getDetails().getUsername(), foodItemEntity);
        em.persist(e);
    }

    public void createFoodItemLike(CognitoPrincipal user, FoodItemEntity foodItemEntity) {
        FoodItemLikesEntity e = new FoodItemLikesEntity(foodItemEntity, user.getDetails().getUsername());
        em.persist(e);
    }

    public void createFoodTruckLike(CognitoPrincipal user, FoodTruckEntity foodTruckEntity) {
        FoodTruckLikesEntity e = new FoodTruckLikesEntity(foodTruckEntity, user.getDetails().getUsername());
        em.persist(e);
    }
}