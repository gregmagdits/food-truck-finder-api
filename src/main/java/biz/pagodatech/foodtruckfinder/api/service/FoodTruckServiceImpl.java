package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckEMRepository;
import biz.pagodatech.foodtruckfinder.api.jpa.repository.FoodTruckRepository;
import biz.pagodatech.foodtruckfinder.api.util.CollectionUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
