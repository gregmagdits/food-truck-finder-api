package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "food_truck_food_item_likes")
public class FoodTruckFoodItemLikesEntity extends  StandardEntity{

    @ManyToOne
    private FoodTruckFoodItemEntity foodItem;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUserEntity user;

}
