package biz.pagodatech.foodtruckfinder.api.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FoodTruckFoodItemResource {
    private final Long id;
    private final String name ;
    private final String description ;
    private final double price ;
    private final String photo ;
}
