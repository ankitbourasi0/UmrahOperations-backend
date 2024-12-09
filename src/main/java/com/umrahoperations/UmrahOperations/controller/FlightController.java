package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.PassportDTO;
import com.umrahoperations.UmrahOperations.model.AirlinesFlight;
import com.umrahoperations.UmrahOperations.model.Airlines_Flights_Details;
import com.umrahoperations.UmrahOperations.model.Flight;
import com.umrahoperations.UmrahOperations.model.FlightSearchFare;
import com.umrahoperations.UmrahOperations.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> findAllAirports() {
        return flightService.findAllAirports();
    }

   /* @GetMapping("/airlines-details")
    public List<Airlines_Flights_Details> getAirlinesFlightsDetails() {
        return flightService.getAirlinesFlightsDetails();
    }*/

    @GetMapping("/current-month")
    public ResponseEntity<List<AirlinesFlight>> getCurrentMonthFlights(
            @RequestParam(value = "referenceDate", defaultValue = "15-12-2024") String referenceDate,
            @RequestParam(value = "fromCity", defaultValue = "101881") Long fromCity,
            @RequestParam(value = "toCity", defaultValue = "103061") Long toCity
            ) {
        log.info("REST request to get current month flights after date: {}", referenceDate);
        List<AirlinesFlight> flights = flightService.getCurrentMonthFlightsAfterDate(referenceDate,fromCity,toCity);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/check-passport")
    public ResponseEntity<PassportDTO> isPassportExist(@RequestParam(value = "passportNo") String passportNo){
        log.info("REST request to check passport: {}", passportNo);
        var passportDTO = flightService.isPassportExist(passportNo);
        return passportDTO != null ? passportDTO : ResponseEntity.notFound().build();
    }

   /* @GetMapping("/id")
    public ResponseEntity<List<Airlines_Flights_Details>> getAirlinesFlightsDetailsById(@RequestParam Long afs_service_id) {
        log.info("REST request to get  flights by Id: {}", afs_service_id);

        var flights = flightService.getAirlinesFlightsDetailsById(afs_service_id);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/search-fare-id")
    public ResponseEntity<List<FlightSearchFare>> getFlightSearchFareByServiceId(@RequestParam Long serviceId) {
        log.info("REST request to get  flights by Id: {}", serviceId);

        var flights = flightService.getFlightSearchFareByServiceId(serviceId);
        return ResponseEntity.ok(flights);
    }
    */
}
