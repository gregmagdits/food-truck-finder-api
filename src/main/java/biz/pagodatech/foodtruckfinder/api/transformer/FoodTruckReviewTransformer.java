package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckReviewEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodTruckReviewTransformer {

    public FoodTruckReviewResource transform(FoodTruckReviewEntity ent){
        return new FoodTruckReviewResource( ent.getRating(), ent.getReview(), ent.getCreatedDate());
    }
    public List<FoodTruckReviewResource> transform(Collection<FoodTruckReviewEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }
}
