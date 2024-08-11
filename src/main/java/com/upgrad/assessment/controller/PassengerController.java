package com.upgrad.assessment.controller;

import com.upgrad.assessment.dto.PassengerDTO;
import com.upgrad.assessment.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public String registerPassenger(@RequestBody PassengerDTO driver){
        return passengerService.createPassenger(driver);
    }

    @GetMapping
    public List<PassengerDTO> retriveAllPassengerDetails(){
        return passengerService.allPassengerDetails();
    }

    @GetMapping(value = "/{id}")
    public PassengerDTO retrivePassenger(@PathVariable int id) throws Exception{
        return passengerService.passengerById(id);
    }

    @PutMapping(value = "/{id}")
    public String updatePassengerDetails(@PathVariable int id, @RequestBody PassengerDTO driverDetails){
        return passengerService.updatePassengerRecords(id,driverDetails);
    }

    @DeleteMapping(value = "/{id}")
    public String deletePassengerDetails(@PathVariable int id){
        return passengerService.deletePassengerRecords(id);
    }
}
