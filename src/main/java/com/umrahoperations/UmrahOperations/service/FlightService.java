package com.umrahoperations.UmrahOperations.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public   List<AirlinesFlight> getCurrentMonthFlightsAfterDate(String referenceDate,Long fromCity,Long toCity) {
        try {
            // Validate the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(referenceDate, formatter);

            log.info("Fetching flights for current month after date: {}", referenceDate);
            log.debug("Parsed date: {}", parsedDate);

            List<AirlinesFlight> flights = airlinesFlightRepository.findFlightsForCurrentMonthAfterDateNative(referenceDate,fromCity,toCity);
            for(AirlinesFlight afs : flights)
			{
            	Long serviceId = afs.getAsId();
            	List<Airlines_Flights_Details> airlinesFlightsDetailsById = airlineFlightDetailsRepository.getAirlinesFlightsDetailsById(serviceId);
            	afs.setLstAirlinesFlightDetails(airlinesFlightsDetailsById);
            	List<FlightSearchFare> flightSearchFareByServiceId = flightSearchFareRepository.getFlightSearchFareByServiceId(serviceId);
            	afs.setLstFlightSearchFare(flightSearchFareByServiceId);
			}
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

   /* public List<Airlines_Flights_Details> getAirlinesFlightsDetails() {
        return airlineFlightDetailsRepository.getAirlinesFlightsDetails();
    }

    public List<Airlines_Flights_Details> getAirlinesFlightsDetailsById(Long afs_service_id) {
        return airlineFlightDetailsRepository.getAirlinesFlightsDetailsById(afs_service_id);
    }

    public List<FlightSearchFare> getFlightSearchFareByServiceId(Long serviceId) {
        return flightSearchFareRepository.getFlightSearchFareByServiceId(serviceId);
    }
*/
}
