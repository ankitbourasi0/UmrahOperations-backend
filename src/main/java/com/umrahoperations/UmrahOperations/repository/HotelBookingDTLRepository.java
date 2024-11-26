package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.HotelBookingDTL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelBookingDTLRepository extends JpaRepository<HotelBookingDTL, Long> {

}