package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public interface FoodTruckService {
    Collection<FoodTruckEntity> getFoodTrucks();

    FoodTruckEntity getFoodTruckByName(String foodTruckName);

    void createFoodTruckReview(User user, String foodTruckName, FoodTruckReviewResource review);
}
