package com.example.garage.service;

import com.example.garage.model.Garage;
import com.example.garage.repasitory.GarageRepasitory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GarageService {
    private final GarageRepasitory garageRepasitory;

    public GarageService(GarageRepasitory garageRepasitory) {
        this.garageRepasitory = garageRepasitory;
    }
    @Cacheable(value = "grage")
    public List<Garage> getAll() {
        return garageRepasitory.findAll();
    }
}
