package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;

import java.util.Collection;

public interface FoodTruckService {
    Collection<FoodTruckEntity> getFoodTrucks();

    FoodTruckEntity getFoodTruckByName(String foodTruckName);
}
