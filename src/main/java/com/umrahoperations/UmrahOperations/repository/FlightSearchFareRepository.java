package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.FlightSearchFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightSearchFareRepository extends JpaRepository<FlightSearchFare,Long> {


    List<FlightSearchFare> getFlightSearchFareByServiceId(@Param("serviceId") Long serviceId);
}
