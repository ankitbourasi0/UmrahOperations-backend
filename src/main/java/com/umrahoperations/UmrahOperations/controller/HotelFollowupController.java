package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.model.HotelFollowup;
import com.umrahoperations.UmrahOperations.service.HotelFollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-followup")
public class HotelFollowupController {

    @Autowired
    private HotelFollowupService hotelFollowupService;

    @GetMapping
    public ResponseEntity<List<HotelFollowup>> getAllBookings() {
        List<HotelFollowup> bookings = hotelFollowupService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
