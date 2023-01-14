package com.example.garage.integration;


import com.example.garage.model.Car;
import com.example.garage.repasitory.CarRepasitory;
import com.example.garage.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.postgresql.hostchooser.HostRequirement.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("dev")
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar() throws Exception {
        when(carService.getById(anyInt())).thenReturn(Car.builder().build());
        mockMvc.perform(get("/cars/" + anyInt()))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();
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
    public void saveNewCarTest() throws Exception {
        when(carService.addCar(any())).thenReturn(Car.builder().build()); //Да, а ты ему объект передаешь, а он ждет что-то типа JSON
        mockMvc.perform(put("/cars/new"))
                .andExpect(status().isOk());
    }
    @Test
    public void saveNewRandomCarTest() throws Exception {
        when(carService.addRandomCar()).thenReturn(Car.builder().build());
        mockMvc.perform(put("/cars/random"))
                .andExpect(status().isOk());
    }
}
