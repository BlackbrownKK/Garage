package com.example.garage.repasitory;

import com.example.garage.model.Garage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GarageRepasitoryImp implements GarageRepasitory  {
    private final JdbcTemplate jdbcTemplate;

    public GarageRepasitoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String innerJoinGarage =
            """
            SELECT * FROM "car"
            INNER JOIN "user" 
            on "user".user_Id = "car".user_Id_Ovner
            """;

    public List<Garage> findAll() {
        return jdbcTemplate.query(innerJoinGarage, new GarageMapper());
    }

}
