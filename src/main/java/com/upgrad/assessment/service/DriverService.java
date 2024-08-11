package com.upgrad.assessment.service;

import com.upgrad.assessment.dto.DriverDTO;
import com.upgrad.assessment.entity.Driver;
import com.upgrad.assessment.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public String createDriver(DriverDTO driverDTO){

        Driver driver = entityMapper(driverDTO);
        Integer driverId = driverRepository.save(driver).getDriverId();
        return "Driver created with driverId: "+driverId;
    }


    public List<DriverDTO> allDriverDetails() {
        List<Driver> driverList = driverRepository.findAll();
        List<DriverDTO> driverDTOList = new ArrayList<>();
        for(Driver d: driverList){
            driverDTOList.add(dtoMapper(d));
        }
        return driverDTOList;
    }

    public DriverDTO driverById(int driverId) throws Exception {
        Optional<Driver> driver = driverRepository.findById(driverId);
        if(driver.isPresent()){
            return dtoMapper(driver.get());
        }else {
            throw new Exception("Driver not present with provided driverId");
        }
    }

    public String updateDriverRecords(int id, DriverDTO driverDetails) {
        Driver driver = entityMapper(driverDetails);
        driver.setDriverId(id);
        driverRepository.save(driver);
        return "Driver records updated successfully";
    }

    public String deleteDriverRecords(int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if(driver.isPresent()){
            driverRepository.delete(driver.get());
        }
        return "Driver records deleted successfully";
    }

    public String updateAvailability(int id) throws Exception {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if(driverOptional.isPresent()){
            Driver driver = driverOptional.get();
            driver.setAvailabilityStatus(!driver.isAvailabilityStatus());
            driverRepository.save(driver);
            return "Availability changed for selected driver";
        }else {
            throw new Exception("Driver not present with provided driverId");
        }
    }

    private Driver entityMapper(DriverDTO dto){
        Driver entity = new Driver();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setVehicleDetails(dto.getVehicleDetails());
        entity.setAvailabilityStatus(true);
        return entity;
    }

    private DriverDTO dtoMapper(Driver dto){
        DriverDTO entity = new DriverDTO();
        entity.setDriverId(dto.getDriverId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setVehicleDetails(dto.getVehicleDetails());
        entity.setAvailabilityStatus(true);
        return entity;
    }
}
