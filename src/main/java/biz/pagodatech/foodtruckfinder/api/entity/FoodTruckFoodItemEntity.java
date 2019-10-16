package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name="food_truck_food_item")
public class FoodTruckFoodItemEntity extends StandardEntity{

    private String name ;
    private String description ;
    private BigDecimal price ;
    private String photo ;
    @OneToMany(mappedBy = "foodItem")
    @EqualsAndHashCode.Exclude
    private Set<FoodTruckFoodItemLikesEntity> likes;
    @OneToMany(mappedBy = "foodItem")
    @EqualsAndHashCode.Exclude
    private Set<FoodTruckFoodItemReviewEntity> reviews;

    @ManyToOne
    @JoinColumn(name="food_truck_id")
    private FoodTruckEntity foodTruck;

}