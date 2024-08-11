package com.upgrad.assessment.service;

import com.upgrad.assessment.dto.PassengerDTO;
import com.upgrad.assessment.entity.Passenger;
import com.upgrad.assessment.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public String createPassenger(PassengerDTO passengerDTO){

        Passenger passenger = entityMapper(passengerDTO);
        Integer passengerId = passengerRepository.save(passenger).getPassengerId();
        return "Passenger created with passengerId: "+passengerId;
    }


    public List<PassengerDTO> allPassengerDetails() {
        List<Passenger> passengerList =passengerRepository.findAll();
        List<PassengerDTO> passengerDTOList = new ArrayList<>();
        for(Passenger d: passengerList){
            passengerDTOList.add(dtoMapper(d));
        }
        return passengerDTOList;
    }

    public PassengerDTO passengerById(int passengerId) throws Exception {
        Optional<Passenger> passenger = passengerRepository.findById(passengerId);
        if(passenger.isPresent()){
            return dtoMapper(passenger.get());
        }else {
            throw new Exception("Passenger not present with provided passengerId");
        }
    }

    public String updatePassengerRecords(int id, PassengerDTO passengerDetails) {
        Passenger passenger = entityMapper(passengerDetails);
        passenger.setPassengerId(id);
        passengerRepository.save(passenger);
        return "Passenger records updated successfully";
    }

    public String deletePassengerRecords(int id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        if(passenger.isPresent()){
            passengerRepository.delete(passenger.get());
        }
        return "Passenger records deleted successfully";
    }

    private Passenger entityMapper(PassengerDTO dto){
        Passenger entity = new Passenger();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    private PassengerDTO dtoMapper(Passenger dto){
        PassengerDTO entity = new PassengerDTO();
        entity.setPassengerId(dto.getPassengerId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }
}
