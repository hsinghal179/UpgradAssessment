package com.upgrad.assessment.controller;

import com.upgrad.assessment.dto.DriverDTO;
import com.upgrad.assessment.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public String registerDriver(@RequestBody DriverDTO driver){
        return driverService.createDriver(driver);
    }

    @GetMapping
    public List<DriverDTO> retriveAllDriverDetails(){
        return driverService.allDriverDetails();
    }

    @GetMapping(value = "/{id}")
    public DriverDTO retriveDriver(@PathVariable int id) throws Exception{
        return driverService.driverById(id);
    }

    @PutMapping(value = "/{id}")
    public String updateDriverDetails(@PathVariable int id, @RequestBody DriverDTO driverDetails){
        return driverService.updateDriverRecords(id,driverDetails);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDriverDetails(@PathVariable int id){
        return driverService.deleteDriverRecords(id);
    }

    @PutMapping(value = "/{id}/availability")
    public String updateAvailability(@PathVariable int id) throws Exception{
        return driverService.updateAvailability(id);
    }

}
