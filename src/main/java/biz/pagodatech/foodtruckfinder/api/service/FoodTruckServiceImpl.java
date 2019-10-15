package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckRepository;
import biz.pagodatech.foodtruckfinder.api.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
@Transactional
public class FoodTruckServiceImpl implements FoodTruckService {

    private FoodTruckRepository repo;
    private Utils utils;
    @Override
    public Collection<FoodTruckEntity> getFoodTrucks() {
        return utils.toCollection(repo.findAll());
    }

    @Override
    public FoodTruckEntity getFoodTruckByName(String foodTruckName) {
        return repo.findByName(foodTruckName).get(0);
    }

}
