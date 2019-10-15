package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="food_truck")
public class FoodTruckEntity extends  StandardEntity{

    private String name;
    private String description;
    private String tagLine;
    private Long foodTruckEstablishmentId;
    private String website;
    private String photo;
    @OneToMany(targetEntity = FoodTruckFoodItemEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "FOOD_TRUCK_ID")
    private List<FoodTruckFoodItemEntity> foodItems;
    // location point;
}
