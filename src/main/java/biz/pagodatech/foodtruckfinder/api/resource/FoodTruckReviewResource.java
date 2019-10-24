package biz.pagodatech.foodtruckfinder.api.resource;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class FoodTruckReviewResource {

    @NotNull
    private final Long  rating;
    @NotBlank
    private final String review;
    private final Date createdDate;
}
