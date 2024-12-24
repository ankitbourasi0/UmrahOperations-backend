package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {


}