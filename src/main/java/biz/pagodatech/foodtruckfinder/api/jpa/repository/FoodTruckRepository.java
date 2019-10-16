package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface FoodTruckRepository extends CrudRepository<FoodTruckEntity, Long>, QueryByExampleExecutor<FoodTruckEntity> {
   List<FoodTruckEntity> findByName(String name);
}
