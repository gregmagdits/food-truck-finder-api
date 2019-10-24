package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckEMRepository;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckRepository;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import biz.pagodatech.foodtruckfinder.api.util.CollectionUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
public class FoodTruckServiceImpl implements FoodTruckService {

    private FoodTruckRepository repo;
    private FoodTruckEMRepository emRepository;
    private CollectionUtils utils;
    @Override
    public Collection<FoodTruckEntity> getFoodTrucks() {
        return emRepository.getFoodTrucks();
    }

    @Override
    public FoodTruckEntity getFoodTruckByName(String foodTruckName) {
        return repo.findByName(foodTruckName).get(0);
    }

    @Override
    public void createFoodTruckReview(User user, String foodTruckName, FoodTruckReviewResource review) {
        throw new NotImplementedException();
    }
    @Override
    public void createFoodItemReview(User user, String foodTruckName, Long foodItemId, FoodItemReviewResource review) {
        throw new NotImplementedException();
    }

    @Override
    public void addFoodItemLike(User user, String foodTruckName, Long foodItemId) {
        throw new NotImplementedException();
    }

    @Override
    public void addFoodTruckLike(User user, String foodTruckName) {
        throw new NotImplementedException();
    }

    @Override
    public FoodItemEntity getFoodItem(Long foodItemId) {
        throw new NotImplementedException();
    }
}
