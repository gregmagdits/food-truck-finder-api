package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FoodTruckEntity {

    private Long id;
    private String name;
    private String description;
    private String tag_line;
    private Long food_truck_establishment_id;
    private String website;
    private String photo;
    // location point;
    private Long created_by;
    private Date created_date;
    private Long modified_by;
    private Date modified_date;

}
