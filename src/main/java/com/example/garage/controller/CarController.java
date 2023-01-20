package com.example.garage.controller;


import com.example.garage.model.Car;
import com.example.garage.service.CarService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @GetMapping("/{id}")
    public String getCar(Model model, @PathVariable int id) {
        model.addAttribute("car", carService.getById(id));
//        System.out.println(carService.getById2(id).getCarId());
        return "Car";
    }

    @GetMapping()
    @Cacheable(value = "cars")
    public String getAll(Model model) {
        model.addAttribute("allCars", carService.getAll());
        return "allCars";
    }

    @PutMapping("/new")
    public String saveNewCar(Model model, @RequestBody Car car) {
        model.addAttribute("car", carService.addCar(car));
        return "Car";
    }

    @PostMapping("/{id}")
    public String updateCar(Model model, @PathVariable int id, @RequestBody Car car) {
        Car updatedCar = carService.getById(id);
        updatedCar.setUserIdOvner(car.getUserIdOvner());
        updatedCar.setModel(car.getModel());
        carService.addCar(updatedCar);
        model.addAttribute("car", updatedCar);
        return "Car";
    }

    @PutMapping("/random")
    public String saveNewRandomCar(Model model) {
        carService.addCar(carService.addRandomCar());
        model.addAttribute("car", carService.addRandomCar());
        return "Car";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(Model model, @PathVariable int id) {
        carService.deleteCar(id);
        model.addAttribute("allCars", carService.getAll());
        return "allCars";
    }
}
