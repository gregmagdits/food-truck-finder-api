package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="food_truck_food_item")
public class FoodTruckFoodItemEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name ;
    private String description ;
    private BigDecimal price ;
    private String photo ;
    private Long createdBy ;
    private Date createdDate ;
    private Long modifiedBy;
    private Date modifiedDate ;
}
