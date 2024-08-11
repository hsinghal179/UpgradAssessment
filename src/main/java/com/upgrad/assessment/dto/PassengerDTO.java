package com.upgrad.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private int passengerId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
