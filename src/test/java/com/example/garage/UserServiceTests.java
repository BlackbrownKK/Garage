package com.example.garage;

import com.example.garage.model.User;
import com.example.garage.repasitory.Dao.UserRepasitory;
import com.example.garage.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    public UserRepasitory userRepasitory;

    @Test
    public void addUserTest() {
        UserService userService = new UserService(userRepasitory);
        User samTest = User.builder().userId(12).name("Sam").build();
        Mockito.when(userRepasitory.save(any())).thenReturn(samTest);
        User user = userService.addUser(any());
        assertEquals(samTest, user);
    }

    @Test
    public void getByIdTest() {
        UserService userService = new UserService(userRepasitory);
        User samTest = User.builder().userId(12).name("Sam").build();
        Mockito.when(userRepasitory.findById(anyInt())).thenReturn(samTest);
        User user = userService.getById(anyInt());
        assertEquals(samTest, user);
    }


    @Test
    public void deleteUserTest() {
        doNothing().when(userRepasitory).deleteUser(anyInt());
        userRepasitory.deleteUser(anyInt());
        verify(userRepasitory, times(1)).deleteUser(anyInt());
    }

    @Test
    public void getAllTest() {
        UserService userService = new UserService(userRepasitory);
        User sam1Test = User.builder().userId(11).name("Sam1").build();
        User sam2Test = User.builder().userId(12).name("Sam2").build();
        User sam3Test = User.builder().userId(13).name("Sam3").build();

        List<User> users = new ArrayList<>();
        users.add(sam1Test);
        users.add(sam2Test);
        users.add(sam3Test);

        Mockito.when(userService.getAll()).thenReturn(users);
        List<User> usersTest = userService.getAll();
        assertEquals(users, usersTest);
    }

    @Test
    public void updateUserTest() {
        UserService userService = new UserService(userRepasitory);
        User testUser= User.builder().userId(11).name("Dan").build();
        doNothing().when(userRepasitory).updateUser(any(), anyInt());
        userService.updateUser(testUser, 11);
        verify(userRepasitory, times(1)).updateUser(any(),anyInt());
    }
}
