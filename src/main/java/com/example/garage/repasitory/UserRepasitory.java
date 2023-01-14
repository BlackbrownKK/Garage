package com.example.garage.repasitory;



import com.example.garage.model.Car;
import com.example.garage.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepasitory extends CrudRepository<User, Integer> {
    List<User> findAll();
}
