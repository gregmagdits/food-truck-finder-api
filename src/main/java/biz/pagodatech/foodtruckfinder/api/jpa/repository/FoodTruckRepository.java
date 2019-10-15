package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodTruckRepository extends CrudRepository<FoodTruckEntity, Long> {
   List<FoodTruckEntity> findByName(String name);
}
