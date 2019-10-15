package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="food_truck")
public class FoodTruckEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    @OneToMany(targetEntity = FoodTruckFoodItemEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "FOOD_TRUCK_ID")
    private List<FoodTruckFoodItemEntity> foodItems;
}
