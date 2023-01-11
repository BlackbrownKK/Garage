package com.example.garage;

import com.example.garage.model.Garage;
import com.example.garage.repasitory.Dao.GarageRepasitory;
import com.example.garage.service.GarageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class GarageServiceTests {

    @Mock
    public GarageRepasitory garageRepasitory;

    @Test
    public void getAllTest() {
        GarageService garageService = new GarageService(garageRepasitory);
        Garage garage1Test = Garage.builder().carId(11).userIdOvner(11).model("Ford1").userId(11).name("Sam1").build();
        Garage garage2Test = Garage.builder().carId(12).userIdOvner(12).model("Ford2").userId(12).name("Sam2").build();
        Garage garage3Test = Garage.builder().carId(13).userIdOvner(13).model("Ford3").userId(13).name("Sam3").build();

        List<Garage> garages = new ArrayList<>();
        garages.add(garage1Test);
        garages.add(garage2Test);
        garages.add(garage3Test);

        Mockito.when(garageService.getAll()).thenReturn(garages);
        List<Garage> garagesTest = garageService.getAll();
        Assertions.assertEquals(garages, garagesTest);
    }
}