package com.example.garage.integration;

import com.example.garage.controller.UserController;
import com.example.garage.model.Car;
import com.example.garage.model.User;
import com.example.garage.service.CarService;
import com.example.garage.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserTest() throws Exception {
        when(userService.getById(anyInt())).thenReturn(User.builder().build());
        mockMvc.perform(get("/users/" + anyInt()))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();
    }


    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("Users"));
    }

    @Test
    public void deleteCarTest() throws Exception {
        when(userService.getById(anyInt())).thenReturn(User.builder().build());
        doNothing().when(userService).deleteUser(anyInt());
        mockMvc.perform(delete("/users/{id}", anyInt())).andExpect(status().isOk());
    }

    @Test
    public void saveNewCarTest() throws Exception {
        when(userService.addUser(any())).thenReturn(User.builder().build());
        mockMvc.perform(put("/users/new").flashAttr("user", User.builder().build()) )
                .andExpect(status().isOk());
    }

}
