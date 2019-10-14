package biz.pagodatech.foodtruckfinder.api.dao;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FoodTruckDao {

    private final static String QUERY_FOOD_TRUCK = "select id ,\n" +
            "name ,\n" +
            "description ,\n" +
            "tag_line ,\n" +
            "food_truck_establishment_id ,\n" +
            "website ,\n" +
            "photo ,\n" +
            "location ,\n" +
            "created_by ,\n" +
            "created_date ,\n" +
            "modified_by,\n" +
            "modified_date  \n" +
            "FROM food_truck";

    private JdbcTemplate jdbc;

    public List<FoodTruckEntity> getAllFoodTrucks() {
        return jdbc.query(QUERY_FOOD_TRUCK, new BeanPropertyRowMapper<FoodTruckEntity>(FoodTruckEntity.class));
    }

    public FoodTruckEntity getFoodTruckByName(String foodTruckName) {
        StringBuilder query = new StringBuilder(QUERY_FOOD_TRUCK);
        query.append(" WHERE name = ? ");
        return jdbc.queryForObject(query.toString(), new BeanPropertyRowMapper<FoodTruckEntity>(FoodTruckEntity.class), foodTruckName);
    }
}
