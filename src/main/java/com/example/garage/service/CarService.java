package com.example.garage.service;


import com.example.garage.model.Car;
import com.example.garage.repasitory.CarRepasitory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CarService {


    private final CarRepasitory carRepasitory;

    public CarService(CarRepasitory carRepasitory) {
        this.carRepasitory = carRepasitory;
    }

    @Cacheable(value = "car", key = "#id")
    public Car getById(int id) {
        return carRepasitory.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }


    @Cacheable(value = "cars")
    public List<Car> getAll() {
        return carRepasitory.findAll();
    }

    public Car addCar(Car car) {
        return carRepasitory.save(car);
    }

    public Car addRandomCar() {
        List<String> models = List.of("BMW", "Mersedes", "Opel", "Audi", "Volkswagen");

        return Car
                .builder()
                .carId(0)
                .userIdOvner(1)
                .model(models.get(getRandomNumber(0, 5)))
                .build();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random()) * (max - min) + min);
    }

    public void deleteCar(int id) {
        carRepasitory.deleteById(id);
    }

}