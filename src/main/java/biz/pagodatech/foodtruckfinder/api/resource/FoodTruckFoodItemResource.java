package biz.pagodatech.foodtruckfinder.api.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class FoodTruckFoodItemResource {
    private final Long id;
    private final String name ;
    private final String description ;
    private final double price ;
    private final String photo ;
    private int numberLikes;
    private boolean canLike;
    private final List<FoodTruckFoodItemReviewResource> reviews;
}
