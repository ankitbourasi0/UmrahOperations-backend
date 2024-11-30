package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.model.Flight;
import com.umrahoperations.UmrahOperations.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> findAllAirports() {
        return flightService.findAllAirports();
    }
}
