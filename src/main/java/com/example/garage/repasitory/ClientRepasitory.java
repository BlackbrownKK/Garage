package com.example.garage.repasitory;

import com.example.garage.model.Car;
import com.example.garage.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepasitory extends CrudRepository<Client, Integer> {
    List<Client> findAll();
    Client findAllByClientEmail(String clientEmail);
}
