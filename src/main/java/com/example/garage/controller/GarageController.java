package com.example.garage.controller;

import com.example.garage.service.GarageService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/garage")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping()
    @Cacheable(value = "garage")
    public String getAll(Model model) {
        model.addAttribute("garage", garageService.getAll());
        return "garage";
    }
}
