package com.example.garage.service;


import com.example.garage.model.User;
import com.example.garage.repasitory.UserRepasitory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserService {
    private final UserRepasitory userRepasitory;

    public UserService(UserRepasitory userRepasitory) {
        this.userRepasitory = userRepasitory;
    }

    public User getById(int id) {
        return userRepasitory.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND));
    }

    public List<User> getAll() {
        return userRepasitory.findAll();
    }

    public User addUser(User user) {
        return this.userRepasitory.save(user);
    }

    public void deleteUser(int id) {
        userRepasitory.deleteById(id);
    }

}
