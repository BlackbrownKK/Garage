package com.example.garage.repasitory;




import com.example.garage.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
@Repository
public interface CarRepasitory extends CrudRepository <Car, Integer>{
    List<Car> findAll();

}
