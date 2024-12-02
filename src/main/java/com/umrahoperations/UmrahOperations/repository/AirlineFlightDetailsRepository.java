package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.Airlines_Flights_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineFlightDetailsRepository extends JpaRepository<Airlines_Flights_Details,Long> {
    @Query(value = "SELECT * FROM Airlines_Flights_Details_View", nativeQuery = true)
    List<Airlines_Flights_Details> getAirlinesFlightsDetails();
}
