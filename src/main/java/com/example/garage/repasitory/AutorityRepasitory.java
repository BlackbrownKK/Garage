package com.example.garage.repasitory;

import com.example.garage.model.Autority;
import com.example.garage.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutorityRepasitory extends CrudRepository<Autority, Integer> {
    List<Autority> findAllByClientId(int id);
}


