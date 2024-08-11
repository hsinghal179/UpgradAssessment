package com.upgrad.assessment.repository;

import com.upgrad.assessment.entity.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Rides,Integer> {
}
