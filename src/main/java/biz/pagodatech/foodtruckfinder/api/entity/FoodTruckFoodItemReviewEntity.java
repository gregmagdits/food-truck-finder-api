package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="food_truck_food_item_reviews")
public class FoodTruckFoodItemReviewEntity extends StandardEntity {
    private Long  rating;
    private String review;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUserEntity user;

    @ManyToOne
    @JoinColumn(name="food_truck_food_item_id")
    private FoodTruckFoodItemEntity foodItem;
}
