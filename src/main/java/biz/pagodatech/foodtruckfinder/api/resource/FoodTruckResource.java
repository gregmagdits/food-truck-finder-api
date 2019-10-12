package biz.pagodatech.foodtruckfinder.api.resource;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FoodTruckResource {

    private final Long id;
    private final String name;
    private final String description;
    private final String tagLine;
    private final String website;
    private final String photo;
    private final double latitude;
    private final double longitude;
}
