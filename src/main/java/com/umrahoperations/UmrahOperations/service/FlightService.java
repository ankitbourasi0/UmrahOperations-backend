package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.model.AirlinesFlight;
import com.umrahoperations.UmrahOperations.model.Airlines_Flights_Details;
import com.umrahoperations.UmrahOperations.model.Flight;
import com.umrahoperations.UmrahOperations.model.FlightSearchFare;
import com.umrahoperations.UmrahOperations.repository.AirlineFlightDetailsRepository;
import com.umrahoperations.UmrahOperations.repository.AirlinesFlightRepository;
import com.umrahoperations.UmrahOperations.repository.FlightRepository;
import com.umrahoperations.UmrahOperations.repository.FlightSearchFareRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineFlightDetailsRepository airlineFlightDetailsRepository;

    private final AirlinesFlightRepository airlinesFlightRepository;

    private final FlightSearchFareRepository flightSearchFareRepository;;

    public   List<AirlinesFlight> getCurrentMonthFlightsAfterDate(String referenceDate) {
        try {
            // Validate the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(referenceDate, formatter);

            log.info("Fetching flights for current month after date: {}", referenceDate);
            log.debug("Parsed date: {}", parsedDate);

            var flights = airlinesFlightRepository.findFlightsForCurrentMonthAfterDateNative(referenceDate);
            log.debug("Found {} flights", flights.size());
            return flights;
        } catch (DateTimeParseException e) {
            log.error("Date parsing failed for input: {}", referenceDate, e);
            throw new IllegalArgumentException("Invalid date format. Please use dd-MM-yyyy", e);
        }
    }


    public List<Flight> findAllAirports() {
        return flightRepository.findAllAirports();
    }

    public List<Airlines_Flights_Details> getAirlinesFlightsDetails() {
        return airlineFlightDetailsRepository.getAirlinesFlightsDetails();
    }

    public List<Airlines_Flights_Details> getAirlinesFlightsDetailsById(Long afs_service_id) {
        return airlineFlightDetailsRepository.getAirlinesFlightsDetailsById(afs_service_id);
    }

    public List<FlightSearchFare> getFlightSearchFareByServiceId(Long serviceId) {
        return flightSearchFareRepository.getFlightSearchFareByServiceId(serviceId);
    }

}
