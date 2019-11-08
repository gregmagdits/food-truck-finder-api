package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public interface FoodTruckService {
    Collection<FoodTruckEntity> getFoodTrucks();

    FoodTruckEntity getFoodTruckByName(String foodTruckName);

    void createFoodTruckReview(UserDetails user, String foodTruckName, FoodTruckReviewResource review);

    void createFoodItemReview(UserDetails user, Long foodItemId, FoodItemReviewResource review);

    void addFoodItemLike(UserDetails user, Long foodItemId);

    void addFoodTruckLike(UserDetails user, String foodTruckName);

    FoodItemEntity getFoodItem(Long foodItemId);
}
