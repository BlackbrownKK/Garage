package com.example.garage.repasitory;


import com.example.garage.model.Car;
import com.example.garage.model.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GarageRepasitory {
    List<Garage> findAll();
}
