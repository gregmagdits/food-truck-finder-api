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
@Table(name = "food_truck_likes")
@AllArgsConstructor
@NoArgsConstructor
public class FoodTruckLikesEntity extends  StandardEntity {

    @ManyToOne
    @JoinColumn(name="food_truck_id")
    private FoodTruckEntity foodTruck;

    @Column(name="app_user")
    private String user;

}
