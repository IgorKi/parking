package com.igorkiv.parking.services.springdatajpa;

import com.igorkiv.parking.model.ParkingSpace;
import com.igorkiv.parking.repositores.ParkingSpaceRepositories;
import com.igorkiv.parking.services.ParkingSpaceService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service("ParkingSDJpaServices")
@Profile("springdatajpa")
public class ParkingSDJpaServices implements ParkingSpaceService {

    private final ParkingSpaceRepositories parkingSpaceRepositories;

    @Override
    public Set<ParkingSpace> findAll() {
        Set<ParkingSpace> parkingSpaces = new HashSet<>();
        parkingSpaceRepositories.findAll().forEach(parkingSpaces::add);
        return parkingSpaces;
    }

    @Override
    public ParkingSpace findById(Long aLong) {
        return parkingSpaceRepositories.findById(aLong).orElse(null);
    }

    @Override
    public ParkingSpace save(ParkingSpace object) {
        return parkingSpaceRepositories.save(object);
    }

    @Override
    public void delete(ParkingSpace object) {
        parkingSpaceRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        parkingSpaceRepositories.deleteById(aLong);
    }
}
