package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {

}