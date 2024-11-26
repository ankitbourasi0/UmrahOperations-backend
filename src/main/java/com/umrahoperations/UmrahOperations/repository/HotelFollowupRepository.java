package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.HotelFollowup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelFollowupRepository extends JpaRepository<HotelFollowup, String> {
    @Query(value = "SELECT * FROM Res_Hotel_Booking_View", nativeQuery = true)
    List<Object[]> findAllBookings();
}
