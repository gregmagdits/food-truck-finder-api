package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.auth.AppUserPrincipal;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;

import java.util.Collection;

public interface FoodTruckService {
    Collection<FoodTruckEntity> getFoodTrucks();

    FoodTruckEntity getFoodTruckByName(String foodTruckName);

    void createFoodTruckReview(AppUserPrincipal user, String foodTruckName, FoodTruckReviewResource review);

    void createFoodItemReview(AppUserPrincipal user, Long foodItemId, FoodItemReviewResource review);

    void addFoodItemLike(AppUserPrincipal user, Long foodItemId);

    void addFoodTruckLike(AppUserPrincipal user, String foodTruckName);

    FoodItemEntity getFoodItem(Long foodItemId);
}
