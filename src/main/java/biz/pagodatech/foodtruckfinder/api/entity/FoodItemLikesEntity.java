package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "food_truck_food_item_likes")
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemLikesEntity extends  StandardEntity{

    @ManyToOne
    @JoinColumn(name="food_item_id")
    private FoodItemEntity foodItem;

    @Column(name="app_user")
    private String user;

}
