package com.igorkiv.parking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "image")
    @Lob
    private Byte[] image;

    @ManyToMany(mappedBy = "cars")
    private Set<ParkingSpace> parkingSpaces;

}
