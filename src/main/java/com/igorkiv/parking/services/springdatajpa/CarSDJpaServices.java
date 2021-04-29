package com.igorkiv.parking.services.springdatajpa;

import com.igorkiv.parking.model.Car;
import com.igorkiv.parking.repositores.CarRepositories;
import com.igorkiv.parking.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Profile("springdatajpa")
public class CarSDJpaServices implements CarService {

    private final CarRepositories carRepositories;

    @Override
    public Set<Car> findAll() {
        Set<Car> cars = new HashSet<>();
        carRepositories.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car findById(Long aLong) {
        return carRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Car save(Car object) {
        return carRepositories.save(object);
    }

    @Override
    public void delete(Car object) {
        carRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carRepositories.deleteById(aLong);
    }
}
