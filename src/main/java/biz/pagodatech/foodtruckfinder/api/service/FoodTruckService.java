package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.auth.CognitoPrincipal;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;

import java.util.Collection;


public interface FoodTruckService {
    Collection<FoodTruckEntity> getFoodTrucks();

    FoodTruckEntity getFoodTruckByName(String foodTruckName);

    void createFoodTruckReview(CognitoPrincipal user, String foodTruckName, FoodTruckReviewResource review);

    void createFoodItemReview(CognitoPrincipal user, Long foodItemId, FoodItemReviewResource review);

    void addFoodItemLike(CognitoPrincipal user, Long foodItemId);

    void addFoodTruckLike(CognitoPrincipal user, String foodTruckName);

    FoodItemEntity getFoodItem(Long foodItemId);
}
