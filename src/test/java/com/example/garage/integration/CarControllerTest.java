package com.example.garage.integration;


import com.example.garage.model.Car;
import com.example.garage.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCar() throws Exception {
        when(carService.getById(anyInt())).thenReturn(Car.builder().build());
        mockMvc.perform(get("/cars/" + anyInt()))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();
    }

    @Test
    public void saveNewCarTest() throws Exception {

        Mockito.when(carService.addCar(any())).thenReturn(Car.builder().build());

        mockMvc.perform(put("/cars/new")
                        .content(objectMapper.writeValueAsString(Car.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("Car"))
                .andExpect(model().attributeExists("car"));
    }

    @Test
    public void updateCarTest() throws Exception {

        Mockito.when(carService.getById(anyInt())).thenReturn(Car.builder().build());

        mockMvc.perform(post("/cars/" + anyInt())
                        .content(objectMapper.writeValueAsString(Car.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("Car"))
                .andExpect(model().attributeExists("car"));
    }

    @Test
    public void getAllCarsTest() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("allCars"));
    }

    @Test
    public void deleteCarTest() throws Exception {
        when(carService.getById(anyInt())).thenReturn(Car.builder().build());
        doNothing().when(carService).deleteCar(anyInt());
        mockMvc.perform(delete("/cars/{id}", anyInt())).andExpect(status().isOk());
    }

    @Test
    public void saveNewRandomCarTest() throws Exception {
        when(carService.addRandomCar()).thenReturn(Car.builder().build());
        mockMvc.perform(put("/cars/random"))
                .andExpect(status().isOk());
    }
}

