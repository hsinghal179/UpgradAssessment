package com.upgrad.assessment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rideId;
    private int passengerId;
    private int driverId;
    private String startLoc;
    private String endLoc;
    private String rideStatus;
    private String fare;
}
