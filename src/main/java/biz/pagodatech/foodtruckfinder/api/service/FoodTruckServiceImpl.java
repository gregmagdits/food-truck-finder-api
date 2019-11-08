package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.exception.FoodItemNotFoundException;
import biz.pagodatech.foodtruckfinder.api.exception.FoodTruckNotFoundException;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodItemRepository;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckEMRepository;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckRepository;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import biz.pagodatech.foodtruckfinder.api.util.CollectionUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class FoodTruckServiceImpl implements FoodTruckService {

    private FoodTruckRepository repo;
    private FoodItemRepository itemRepository;
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
    public void createFoodTruckReview(UserDetails user, String foodTruckName, FoodTruckReviewResource review) {
        emRepository.createFoodTruckReview(user, getFoodTruckByNameHelper(foodTruckName), review.getRating(), review.getReview());
    }

    @Override
    public void createFoodItemReview(UserDetails user, Long foodItemId, FoodItemReviewResource review) {
        emRepository.createFoodItemReview(user, getFoodItemHelper(foodItemId), review.getRating(), review.getReview());
    }

    @Override
    public void addFoodItemLike(UserDetails user, Long foodItemId) {
        emRepository.createFoodItemLike(user, getFoodItemHelper(foodItemId));
    }

    @Override
    public void addFoodTruckLike(UserDetails user, String foodTruckName) {
        emRepository.createFoodTruckLike(user, getFoodTruckByNameHelper(foodTruckName));
    }

    @Override
    public FoodItemEntity getFoodItem(Long foodItemId) {
        return getFoodItemHelper(foodItemId);
    }

    private FoodTruckEntity getFoodTruckByNameHelper(String foodTruckName){
        List<FoodTruckEntity> results = repo.findByName(foodTruckName);
        if (org.apache.commons.collections4.CollectionUtils.isEmpty(results)){
            throw new FoodTruckNotFoundException(foodTruckName);
        }
        return results.get(0);
    }

    private FoodItemEntity getFoodItemHelper(Long foodItemId){
        Optional<FoodItemEntity> entity = itemRepository.findById(foodItemId);
        return entity.orElseThrow(()-> new FoodItemNotFoundException(foodItemId));
    }
}
