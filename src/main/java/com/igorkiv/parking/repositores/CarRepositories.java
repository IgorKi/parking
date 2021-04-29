package com.igorkiv.parking.repositores;

import com.igorkiv.parking.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepositories extends CrudRepository<Car, Long> {
}
