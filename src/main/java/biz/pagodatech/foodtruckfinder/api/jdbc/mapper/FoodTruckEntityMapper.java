package biz.pagodatech.foodtruckfinder.api.jdbc.mapper;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Deprecated
@Component
public class FoodTruckEntityMapper implements RowMapper<FoodTruckEntity> {
    public FoodTruckEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        FoodTruckEntity truck = new FoodTruckEntity();
        truck.setId(rs.getLong("id"));
        truck.setName(rs.getString("name"));
        truck.setDescription(rs.getString("description"));
        truck.setPhoto(rs.getString("photo"));
        truck.setDescription(rs.getString("website"));
        truck.setTagLine(rs.getString("tag_line"));
        truck.setFoodTruckEstablishmentId(rs.getLong("food_truck_establishment_id"));



        return truck;
    }
}
