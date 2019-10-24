package biz.pagodatech.foodtruckfinder.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FoodTruckNotFoundException extends RuntimeException {
    private final String foodTruckName;
}
