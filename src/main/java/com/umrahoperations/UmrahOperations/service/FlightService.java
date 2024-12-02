package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.model.Airlines_Flights_Details;
import com.umrahoperations.UmrahOperations.model.Flight;
import com.umrahoperations.UmrahOperations.repository.AirlineFlightDetailsRepository;
import com.umrahoperations.UmrahOperations.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineFlightDetailsRepository airlineFlightDetailsRepository;

    public List<Flight> findAllAirports() {
        return flightRepository.findAllAirports();
    }

    public List<Airlines_Flights_Details> getAirlinesFlightsDetails() {
        return airlineFlightDetailsRepository.getAirlinesFlightsDetails();
    }

}
