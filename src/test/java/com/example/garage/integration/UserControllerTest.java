package com.example.garage.integration;


import com.example.garage.model.User;
import com.example.garage.service.UserService;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveNewUserTest() throws Exception {
        when(userService.addUser(any())).thenReturn(User.builder().build());
        mockMvc.perform(put("/users/new")
                        .content(objectMapper.writeValueAsString(User.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("User"))
                .andExpect(model().attributeExists("user"));
    }
    @Test
    public void updateUserTest() throws Exception {

        Mockito.when(userService.getById(anyInt())).thenReturn(User.builder().build());

        mockMvc.perform(post("/users/" + anyInt())
                        .content(objectMapper.writeValueAsString(User.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("User"))
                .andExpect(model().attributeExists("user"));
    }
    @Test
    public void deleteUserTest() throws Exception {
        when(userService.getById(anyInt())).thenReturn(User.builder().build());
        doNothing().when(userService).deleteUser(anyInt());
        mockMvc.perform(delete("/users/{id}", anyInt())).andExpect(status().isOk());
    }
}
