package com.umrahoperations.UmrahOperations.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.umrahoperations.UmrahOperations.dto.PassportDTO;
import com.umrahoperations.UmrahOperations.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.umrahoperations.UmrahOperations.model.AirlinesFlight;
import com.umrahoperations.UmrahOperations.model.Airlines_Flights_Details;
import com.umrahoperations.UmrahOperations.model.Flight;
import com.umrahoperations.UmrahOperations.model.FlightSearchFare;

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

    private final FlightSearchFareRepository flightSearchFareRepository;

    @Autowired
    private PassportCheckRepository passportCheckRepository;

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

    public ResponseEntity<PassportDTO> isPassportExist(String passportNo) {
    	try{
          var passports =   passportCheckRepository.findAllPassport();
          if (!passports.isEmpty()){
                for (PassportDTO passport : passports){
                    if (passport.getMt_passport().equals(passportNo)){
                        return ResponseEntity.ok(passport);
                    }
                }

          }
            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            throw new RuntimeException("Error in Finding Passport", e);
        }


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
