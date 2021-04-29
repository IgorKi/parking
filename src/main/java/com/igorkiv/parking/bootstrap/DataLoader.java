package com.igorkiv.parking.bootstrap;

import com.igorkiv.parking.model.ParkingSpace;
import com.igorkiv.parking.services.ParkingSpaceService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

//    @Qualifier("ParkingSpaceMap")
    private final ParkingSpaceService parkingSpaceService;

    @Override
    public void run(String... args) throws Exception {

        for (char i = 'A'; i < 'F'; i++){
            for (int j = 1; j < 5; j++)
            {
                parkingSpaceService.save(ParkingSpace.builder()
                        .number(j)
                        .sector(i)
                        .status(getRandomBoolean())
                        .build());
            }
        }
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

}
