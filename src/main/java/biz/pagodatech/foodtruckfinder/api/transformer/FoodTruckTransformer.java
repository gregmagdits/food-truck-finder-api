package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodTruckTransformer {

    public FoodTruckResource transform(FoodTruckEntity ent){
        return new FoodTruckResource(ent.getId(),ent.getName(),ent.getDescription(),ent.getTagLine(),ent.getWebsite(),ent.getPhoto(), 0.0, 0.0);
    }

    public List<FoodTruckResource> transform(List<FoodTruckEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }
}