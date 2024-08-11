package com.upgrad.assessment.service;

import com.upgrad.assessment.dto.RidesDTO;
import com.upgrad.assessment.entity.Rides;
import com.upgrad.assessment.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository driverRepository;

    public String createDriver(RidesDTO driverDTO){

        Rides driver = entityMapper(driverDTO);
        Integer driverId = driverRepository.save(driver).getDriverId();
        return "Driver created with driverId: "+driverId;
    }


    public List<RidesDTO> allDriverDetails() {
        List<Rides> driverList = driverRepository.findAll();
        List<RidesDTO> driverDTOList = new ArrayList<>();
        for(Rides d: driverList){
            driverDTOList.add(dtoMapper(d));
        }
        return driverDTOList;
    }

    public RidesDTO driverById(int driverId) throws Exception {
        Optional<Rides> driver = driverRepository.findById(driverId);
        if(driver.isPresent()){
            return dtoMapper(driver.get());
        }else {
            throw new Exception("Driver not present with provided driverId");
        }
    }

    public String updateDriverRecords(int id, RidesDTO driverDetails) {
        Rides driver = entityMapper(driverDetails);
        driver.setRideId(id);
        driverRepository.save(driver);
        return "Driver records updated successfully";
    }

    public String deleteDriverRecords(int id) {
        Optional<Rides> driver = driverRepository.findById(id);
        if(driver.isPresent()){
            driverRepository.delete(driver.get());
        }
        return "Driver records deleted successfully";
    }

    public String updateAvailability(int id, String status) throws Exception {
        Optional<Rides> driverOptional = driverRepository.findById(id);
        if(driverOptional.isPresent()){
            Rides driver = driverOptional.get();
            driver.setRideStatus(status);
            driverRepository.save(driver);
            return "Availability changed for selected driver";
        }else {
            throw new Exception("Driver not present with provided driverId");
        }
    }

    private Rides entityMapper(RidesDTO dto){
        Rides entity = new Rides();
        entity.setDriverId(dto.getDriverId());
        entity.setDriverId(dto.getDriverId());
        entity.setStartLoc(dto.getStartLoc());
        entity.setEndLoc(dto.getEndLoc());
        entity.setRideStatus(dto.getRideStatus());
        entity.setFare(dto.getFare());
        return entity;
    }

    private RidesDTO dtoMapper(Rides dto){
        RidesDTO entity = new RidesDTO();
        entity.setRideId(dto.getRideId());
        entity.setDriverId(dto.getDriverId());
        entity.setDriverId(dto.getDriverId());
        entity.setStartLoc(dto.getStartLoc());
        entity.setEndLoc(dto.getEndLoc());
        entity.setRideStatus(dto.getRideStatus());
        entity.setFare(dto.getFare());
        return entity;
    }
}
