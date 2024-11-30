package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT SL, CODE,  CITY, COUNTRY, SUGGEST_NAME, SHORT_CODE FROM V_LUK_AIRPORTS", nativeQuery = true)
    List<Flight> findAllAirports();
}
