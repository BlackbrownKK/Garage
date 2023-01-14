package com.example.garage.integration;


import com.example.garage.controller.CarController;
import com.example.garage.controller.GarageController;
import com.example.garage.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestingWebApplicationTests {


    @Autowired
    private CarController carController;

    @Autowired
    private UserController userController;

    @Autowired
    private GarageController garageController;

    @Test
    public void contextLoadsCarController() throws Exception {
        assertThat(carController).isNotNull();
    }

    @Test
    public void contextLoadsUserController() throws Exception {
        assertThat(userController).isNotNull();
    }

    @Test
    public void contextLoadsGarageController() throws Exception {
        assertThat(garageController).isNotNull();
    }
}
