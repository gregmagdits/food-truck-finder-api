package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name="food_truck_food_item")
public class FoodTruckFoodItemEntity extends StandardEntity{

    private String name ;
    private String description ;
    private BigDecimal price ;
    private String photo ;
    @OneToMany
    @JoinColumn(name="food_truck_food_item_id")
    private List<FoodTruckFoodItemLikesEntity> likes;

}
