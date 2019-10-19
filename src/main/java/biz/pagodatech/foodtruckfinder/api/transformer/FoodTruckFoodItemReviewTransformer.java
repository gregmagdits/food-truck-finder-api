package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckFoodItemReviewEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemReviewResource;
import org.springframework.stereotype.Component;

@Component
public class FoodTruckFoodItemReviewTransformer {

    public FoodTruckFoodItemReviewResource transform(FoodTruckFoodItemReviewEntity ent){
        return new FoodTruckFoodItemReviewResource( ent.getRating(), ent.getReview(), ent.getCreatedDate());
    }

}
