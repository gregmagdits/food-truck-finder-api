package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FoodTruckTransformer {

    private FoodTruckFoodItemTransformer transformer;

    public FoodTruckResource transform(FoodTruckEntity ent){
        List<FoodTruckFoodItemResource> items = transformer.transform(ent.getFoodItems());
        return new FoodTruckResource(ent.getId(),ent.getName(),ent.getDescription(),ent.getTagLine(),ent.getWebsite(),ent.getPhoto(), 0.0, 0.0, items);
    }

    public List<FoodTruckResource> transform(Collection<FoodTruckEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }
}