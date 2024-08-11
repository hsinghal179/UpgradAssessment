package com.upgrad.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private int driverId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String vehicleDetails;
    private boolean availabilityStatus;
}
