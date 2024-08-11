package com.upgrad.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RidesDTO {
    private int rideId;
    private int passengerId;
    private int driverId;
    private String startLoc;
    private String endLoc;
    private String rideStatus;
    private String fare;
}
