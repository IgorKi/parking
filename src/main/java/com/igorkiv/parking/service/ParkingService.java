package com.igorkiv.parking.service;

import com.igorkiv.parking.model.ParkingSpace;

import java.util.List;

public interface ParkingService {

    List<ParkingSpace> showAll();

    boolean entrance();

    void exit();

    Long freeSpaces();

    //TODO: занятие одного паркинг места
}
