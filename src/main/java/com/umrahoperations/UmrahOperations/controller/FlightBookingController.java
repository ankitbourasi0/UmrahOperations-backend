package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.FlightBookingDTO;
import com.umrahoperations.UmrahOperations.service.FlightBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flight-booking")
@Slf4j
public class FlightBookingController {
    private final FlightBookingService flightBookingService;

    @Autowired
    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }
    @PostMapping
    public ResponseEntity<FlightBookingDTO> createFlightBooking(@RequestBody FlightBookingDTO bookingDTO) {
        log.info("Creating new flight booking");
        log.info("Check Request Body: {}", bookingDTO);
        FlightBookingDTO savedBooking = flightBookingService.saveFlightBooking(bookingDTO);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }
}
