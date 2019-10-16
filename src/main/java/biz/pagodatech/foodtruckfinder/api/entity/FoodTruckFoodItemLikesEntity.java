package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "food_truck_food_item_likes")
public class FoodTruckFoodItemLikesEntity extends  StandardEntity{

    @ManyToOne
    @JoinColumn(name="food_truck_food_item_id")
    private FoodTruckFoodItemEntity foodItem;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUserEntity user;

}
