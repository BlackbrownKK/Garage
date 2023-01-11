package com.example.garage;

import com.example.garage.model.Car;
import com.example.garage.repasitory.Dao.CarRepasitory;
import com.example.garage.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTests {

    @Mock
    public CarRepasitory carRepasitory;

    @Test
    public void addCarTest() {
        CarService carService = new CarService(carRepasitory);
        Car fordTest = Car.builder().carId(12).userIdOvner(12).model("Ford").build();
        Mockito.when(carRepasitory.save(any())).thenReturn(fordTest);
        Car car = carService.addCar(any());
        Assertions.assertEquals(fordTest, car);
    }

    @Test
    public void getByIdTest() {
        CarService carService = new CarService(carRepasitory);
        Car fordTest = Car.builder().carId(0).userIdOvner(0).model("Ford").build();
        Mockito.when(carRepasitory.findById(anyInt())).thenReturn(fordTest);
        Car car = carService.getById(anyInt());
        Assertions.assertEquals(fordTest, car);
    }

    @Test
    public void getAllTest() {
        CarService carService = new CarService(carRepasitory);
        Car ford1Test = Car.builder().carId(11).userIdOvner(11).model("Ford1").build();
        Car ford2Test = Car.builder().carId(12).userIdOvner(12).model("Ford2").build();
        Car ford3Test = Car.builder().carId(13).userIdOvner(13).model("Ford3").build();
        List<Car> cars = new ArrayList<>();

        cars.add(ford1Test);
        cars.add(ford2Test);
        cars.add(ford3Test);

        Mockito.when(carService.getAll()).thenReturn(cars);
        List<Car> carsTest = carService.getAll();
        Assertions.assertEquals(cars, carsTest);
    }

    @Test
    public void addRandomCarTest() {
        CarService carService = new CarService(carRepasitory);
        Car car1Test = Car.builder().carId(0).userIdOvner(0).model("BMW").build();
        Car car2Test = Car.builder().carId(0).userIdOvner(0).model("Mersedes").build();
        Car car3Test = Car.builder().carId(0).userIdOvner(0).model("Opel").build();
        Car car4Test = Car.builder().carId(0).userIdOvner(0).model("Audi").build();
        Car car5Test = Car.builder().carId(0).userIdOvner(0).model("Volkswagen").build();
        Car car = carService.addRandomCar();

        if (car1Test.equals(car)) {
            Assertions.assertEquals(car1Test, car);
        } else if (car2Test.equals(car)) {
            Assertions.assertEquals(car2Test, car);
        } else if (car3Test.equals(car)) {
            Assertions.assertEquals(car3Test, car);
        } else if (car4Test.equals(car)) {
            Assertions.assertEquals(car4Test, car);
        } else {
            Assertions.assertEquals(car5Test, car);
        }
    }

    @Test
    public void deleteCarTest() {
        doNothing().when(carRepasitory).deleteCar(anyInt());
        carRepasitory.deleteCar(anyInt());
        verify(carRepasitory, times(1)).deleteCar(anyInt());
    }

    @Test
    public void updateCarTest() {
        CarService carService = new CarService(carRepasitory);
        Car testCar = Car.builder().carId(0).userIdOvner(0).model("BMW").build();
        doNothing().when(carRepasitory).updateCar(any(), anyInt());
        carService.updateCar(testCar, 0);
        verify(carRepasitory, times(1)).updateCar(any(), anyInt());
    }

    @Test
    public void getRandomNumberTest() {
        int realNummer = CarService.getRandomNumber(1, 5);

        if (realNummer == 1) {
            Assertions.assertEquals(realNummer, 1);
        } else if (realNummer == 2) {
            Assertions.assertEquals(realNummer, 2);
        } else if (realNummer == 3) {
            Assertions.assertEquals(realNummer, 3);
        } else if (realNummer == 4) {
            Assertions.assertEquals(realNummer, 4);
        } else {
            Assertions.assertEquals(realNummer, 5);
        }
    }
}


