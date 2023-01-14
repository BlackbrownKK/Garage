package com.example.garage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
public class Garage {

    private int carId;
    private String model;
    @Id
    private int userIdOvner;
    private int userId;
    private String name;
}
