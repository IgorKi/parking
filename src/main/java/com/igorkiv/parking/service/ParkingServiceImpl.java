package com.igorkiv.parking.service;

import com.igorkiv.parking.model.ParkingSpace;
import com.igorkiv.parking.services.ParkingSpaceService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("ParkingServiceImpl")
public class ParkingServiceImpl implements ParkingService {

    private final ParkingSpaceService parkingSpaceService;

    public ParkingServiceImpl(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @Override
    public List<ParkingSpace> showAll() {
        List<ParkingSpace> parkingSpaceList = new ArrayList<>();

        parkingSpaceService.findAll().stream()
                .sorted(Comparator.comparing(ParkingSpace::getNumber))
                .sorted(Comparator.comparing(ParkingSpace::getSector))
                .forEach(parkingSpaceList::add);

        return parkingSpaceList;
    }

    // Шлагбаум 1 опрашивают приложение на разрешение на въезд
    @Override
    public boolean entrance() {
        //занятие одного паркинг места
        Set<ParkingSpace> lots = parkingSpaceService.findAll();
        for (ParkingSpace lot: lots) {
            if (lot.isStatus()){
                lot.setStatus(false);
                parkingSpaceService.save(lot);
                return true;
            }
        }
        return false;
    }

    // Шлагбаум 2 выезд
    @Override
    public void exit() {

        Set<ParkingSpace> lots = parkingSpaceService.findAll();
        for (ParkingSpace lot:lots) {
            if (!lot.isStatus()){
                lot.setStatus(true);
                parkingSpaceService.save(lot);
                return;
            }
        }
    }

    //TODO: вынести в сервис поиск свободных мест
    public Long freeSpaces(){
        return  parkingSpaceService.findAll().stream().filter(p ->p.isStatus()).count();
    }
    //TODO: занятие одного паркинг места

}
