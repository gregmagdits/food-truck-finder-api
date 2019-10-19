package biz.pagodatech.foodtruckfinder.api.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class FoodTruckFoodItemReviewResource {
    private final Long  rating;
    private final String review;
    private final Date createdDate;
}
