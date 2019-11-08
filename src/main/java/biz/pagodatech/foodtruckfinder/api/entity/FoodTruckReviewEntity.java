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
@Table(name="food_truck_reviews")
@AllArgsConstructor
@NoArgsConstructor
public class FoodTruckReviewEntity extends  StandardEntity{
    private Long  rating;
    private String review;

    @Column(name="app_user")
    private String user;

    @ManyToOne
    @JoinColumn(name="food_truck_id")
    private FoodTruckEntity foodTruck;

}
