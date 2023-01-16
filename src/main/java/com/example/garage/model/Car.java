package com.example.garage.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder

public class Car {
    @Id
    private int carId;
    private int userIdOvner;
    private String model;
}
