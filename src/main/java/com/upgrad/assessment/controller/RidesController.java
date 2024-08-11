package com.upgrad.assessment.controller;

import com.upgrad.assessment.dto.RidesDTO;
import com.upgrad.assessment.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rides")
public class RidesController {
    @Autowired
    private RideService rideService;

    @PostMapping
    public String registerDriver(@RequestBody RidesDTO driver){
        return rideService.createDriver(driver);
    }

    @GetMapping
    public List<RidesDTO> retriveAllDriverDetails(){
        return rideService.allDriverDetails();
    }

    @GetMapping(value = "/{id}")
    public RidesDTO retriveDriver(@PathVariable int id) throws Exception{
        return rideService.driverById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateDriverDetails(@PathVariable int id, @RequestBody RidesDTO driverDetails){
        return rideService.updateDriverRecords(id,driverDetails);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDriverDetails(@PathVariable int id){
        return rideService.deleteDriverRecords(id);
    }

    @PutMapping(value = "/{id}/{status}")
    public String updateAvailability(@PathVariable int id, @PathVariable String status) throws Exception{
        return rideService.updateAvailability(id,status);
    }
}
