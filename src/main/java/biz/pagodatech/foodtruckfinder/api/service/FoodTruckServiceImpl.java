package biz.pagodatech.foodtruckfinder.api.service;

import biz.pagodatech.foodtruckfinder.api.dao.FoodTruckDao;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FoodTruckServiceImpl implements FoodTruckService {

    private FoodTruckDao dao;
    @Override
    public List<FoodTruckEntity> getFoodTrucks() {
        return dao.getAllFoodTrucks();
    }

    @Override
    public FoodTruckEntity getFoodTruckByName(String foodTruckName) {
        return dao.getFoodTruckByName(foodTruckName);
    }

}
