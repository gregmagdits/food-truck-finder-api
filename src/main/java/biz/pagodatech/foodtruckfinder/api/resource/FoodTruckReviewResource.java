package biz.pagodatech.foodtruckfinder.api.resource;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodTruckReviewResource {

    @JsonProperty("rating")
    @NotNull
    private  Long  rating;

    @JsonProperty("review")
    @NotBlank
    private  String review;

    @JsonProperty("created_date")
    private  Date createdDate;

}
