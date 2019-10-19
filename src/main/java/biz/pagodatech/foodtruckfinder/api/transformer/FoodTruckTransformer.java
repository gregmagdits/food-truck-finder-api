package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FoodTruckTransformer {

    private FoodItemTransformer foodItemTransformer;
    private FoodTruckReviewTransformer reviewTransformer;
    //private GenericTransformer t;

    public FoodTruckResource transform(FoodTruckEntity ent){
        List<FoodTruckReviewResource> reviews = reviewTransformer.transform(ent.getReivews());
        List<FoodItemResource> items = foodItemTransformer.transform(ent.getFoodItems());
        return new FoodTruckResource(ent.getId(),ent.getName(),ent.getDescription(),ent.getTagLine(),ent.getWebsite(),ent.getPhoto(), 0.0, 0.0, items, reviews);
    }

    public List<FoodTruckResource> transform(Collection<FoodTruckEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }
}