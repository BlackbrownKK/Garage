package com.example.garage.repasitory;

import com.example.garage.model.Garage;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GarageMapper implements RowMapper<Garage> {
    @Override
    public Garage mapRow(ResultSet rows, int rowNum) throws SQLException {

        return Garage.builder()
                .userId(rows.getInt("user_Id"))
                .name(rows.getString("name"))
                .carId(rows.getInt("car_Id"))
                .userIdOvner(rows.getInt("user_Id_Ovner"))
                .model(rows.getString("model"))
                .build();
    }
}