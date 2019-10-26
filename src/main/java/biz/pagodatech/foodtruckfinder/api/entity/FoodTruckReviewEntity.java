package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="food_truck_reviews")
@AllArgsConstructor
public class FoodTruckReviewEntity extends  StandardEntity{
    private Long  rating;
    private String review;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUserEntity user;

    @ManyToOne
    @JoinColumn(name="food_truck_id")
    private FoodTruckEntity foodTruck;

}
