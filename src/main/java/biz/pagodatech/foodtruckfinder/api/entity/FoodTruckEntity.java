package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FoodTruckEntity {

    private Long id;
    private String name;
    private String description;
    private String tagLine;
    private Long foodTruckEstablishmentId;
    private String website;
    private String photo;
    // location point;
    private Long createdBy;
    private Date createdDate;
    private Long modifiedBy;
    private Date modifiedDate;

}
