package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
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


    public void createFoodTruckReview(User user, FoodTruckEntity foodTruckByNameHelper, Long rating, String review) {
        throw new NotImplementedException();
    }

    public void createFoodItemReview(User user, FoodItemEntity foodItemHelper, Long rating, String review) {
        throw new NotImplementedException();
    }

    public void createFoodItemLike(User user, FoodItemEntity foodItemHelper) {
        throw new NotImplementedException();
    }

    public void createFoodTruckLike(User user, FoodTruckEntity foodTruckByNameHelper) {
        throw new NotImplementedException();
    }
}