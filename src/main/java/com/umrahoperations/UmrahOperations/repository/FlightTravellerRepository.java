package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.FlightTraveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTravellerRepository extends JpaRepository<FlightTraveller, Long> {
}