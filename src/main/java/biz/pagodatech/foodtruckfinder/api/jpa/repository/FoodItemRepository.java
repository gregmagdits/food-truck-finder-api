package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FoodItemRepository extends CrudRepository<FoodItemEntity, Long>, QueryByExampleExecutor<FoodItemEntity> {
}
