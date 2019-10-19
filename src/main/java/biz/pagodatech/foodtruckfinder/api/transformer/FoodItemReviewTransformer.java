package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemReviewEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import org.springframework.stereotype.Component;

@Component
public class FoodItemReviewTransformer {

    public FoodItemReviewResource transform(FoodItemReviewEntity ent){
        return new FoodItemReviewResource( ent.getRating(), ent.getReview(), ent.getCreatedDate());
    }

}
