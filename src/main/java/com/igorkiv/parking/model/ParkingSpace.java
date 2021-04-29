package com.igorkiv.parking.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "parking_spaces")
public class ParkingSpace extends BaseEntity {

    @Column(name = "number")
    private Integer number;

    @Column(name = "sector")
    private char sector;

    @Column(name = "status")
    private boolean status;

    @Enumerated(value = EnumType.STRING)
    private SpaceStatus spaceStatus;

    @ManyToMany
    @JoinTable(name="parking_space_cars",
            joinColumns = @JoinColumn(name = "parking_space_id"),
                inverseJoinColumns = @JoinColumn(name = "cars_id"))
    private Set<Car> cars;

    @Override
    public String toString() {
        return "BaseEntity{" +
              //  "id=" + super.id.toString() +
                ", number=" + number +
                ", sector=" + sector +
                ", status=" + status +
                '}';
    }

}
