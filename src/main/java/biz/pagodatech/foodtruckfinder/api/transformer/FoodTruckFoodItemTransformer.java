package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckFoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemResource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodTruckFoodItemTransformer {

    public FoodTruckFoodItemResource transform(FoodTruckFoodItemEntity ent){
        return new FoodTruckFoodItemResource( ent.getId(), ent.getName(), ent.getDescription(), ent.getPrice().doubleValue(), ent.getPhoto());
    }

    public List<FoodTruckFoodItemResource> transform(Collection<FoodTruckFoodItemEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }

}
