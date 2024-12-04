package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.AirlinesFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlinesFlightRepository extends JpaRepository<AirlinesFlight, Long> {
    @Query(value = "SELECT * FROM Airlines_Flight_Search " +
            "WHERE to_char(to_date(departure_date,'dd-MM-yy'),'MM') =  " +
            "to_char(to_date(:referenceDate,'dd-MM-yyyy'),'MM') " +
            "AND to_date(departure_date,'dd-MM-yyyy') > to_date(:referenceDate,'dd-MM-yyyy')"
            + " and as_id IN (select afs_service_id from Airlines_Flights_Details where afs_departure_airport = :fromCity and  afs_segment=1001) "
            + " and as_id IN (select afs_service_id from Airlines_Flights_Details where afs_departure_airport = :toCity and  afs_segment=1002) ",
            nativeQuery = true)
    List<AirlinesFlight> findFlightsForCurrentMonthAfterDateNative(
            @Param("referenceDate") String referenceDate , @Param("fromCity") Long fromCityId,@Param("toCity") Long toCityId
    );
}