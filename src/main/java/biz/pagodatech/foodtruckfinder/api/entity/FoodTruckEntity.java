package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@NamedEntityGraph(
        name = "food-truck-with-items-fully-populated",
        attributeNodes = {
                @NamedAttributeNode(value = "foodItems", subgraph = "items-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "items-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("likes"),
                                @NamedAttributeNode("reviews")
                        }
                )
        }
)
@Data
@Entity
@Table(name="food_truck")
public class FoodTruckEntity extends  StandardEntity{

    private String name;
    private String description;
    private String tagLine;
    private Long foodTruckEstablishmentId;
    private String website;
    private String photo;
    @OneToMany(mappedBy = "foodTruck")
    //@JoinColumn(name = "FOOD_TRUCK_ID")
    private Set<FoodTruckFoodItemEntity> foodItems;
    @OneToMany(mappedBy = "foodTruck")
    //@JoinColumn(name = "FOOD_TRUCK_ID")
    private Set<FoodTruckReviewEntity> reivews;

    // location point;
}
