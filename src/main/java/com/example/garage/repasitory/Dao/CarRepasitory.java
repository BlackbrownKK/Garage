package com.example.garage.repasitory.Dao;




import com.example.garage.model.Car;

import java.util.List;

public interface CarRepasitory {
    Car findById(int id);

    List<Car> getAll();

    Car save(Car car);

    void updateCar(Car car, int id);

    void deleteCar(int id);

}
