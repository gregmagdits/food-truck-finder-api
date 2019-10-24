package biz.pagodatech.foodtruckfinder.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FoodItemNotFoundException extends RuntimeException {
   private final Long foodItemId;
}
